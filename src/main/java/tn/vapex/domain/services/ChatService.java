package tn.vapex.domain.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.vapex.domain.entitites.Conversation;
import tn.vapex.domain.entitites.Message;
import tn.vapex.domain.entitites.User;
import tn.vapex.domain.exceptions.exceptions.UserNotFoundException;
import tn.vapex.domain.repositories.ConversationRepository;
import tn.vapex.domain.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ConversationRepository conversationRepository;
    private final UserRepository userRepository;

    public Conversation getConversationBetween(User userConnected, User user) {
        Optional<Conversation> conversationOptional = this.conversationRepository.findConversationBetween(userConnected, user);
        return conversationOptional.orElseGet(() -> this.conversationRepository.save(Conversation.between(userConnected, user)));
    }

    public Conversation getConversationBetween(User userConnected, long userId) {
        User user = this.getUserById(userId);
        return this.getConversationBetween(userConnected, user);
    }

    public Message sendMessage(User sender, long recipientId, Message message) {
        User recipient = this.getUserById(recipientId);
        Conversation conversation = this.getConversationBetween(sender, recipientId);
        message.setSender(sender);
        message.setRecipient(recipient);
        conversation.addMessage(message);
        this.conversationRepository.save(conversation);
        return message;
    }

    private User getUserById(long id) {
        return this.userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
