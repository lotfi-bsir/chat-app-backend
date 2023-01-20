package tn.vapex.domain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import tn.vapex.domain.entitites.Conversation;
import tn.vapex.domain.entitites.Message;
import tn.vapex.domain.entitites.User;
import tn.vapex.domain.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ChatService chatService;

    public List<Pair<User, Message>> getContactList(User connectedUser) {
        List<User> users = this.userRepository.getAllExcept(connectedUser.getId());
        return users.stream().map(user -> {
            Conversation conversation = this.chatService.getConversationBetween(connectedUser, user);
            Message lastMessage = new Message();
            if (conversation.hasMessages()) {
                lastMessage = conversation.getMessages().get(conversation.getMessages().size() - 1);
            }
            return Pair.of(user, lastMessage);
        }).collect(Collectors.toList());
    }


}
