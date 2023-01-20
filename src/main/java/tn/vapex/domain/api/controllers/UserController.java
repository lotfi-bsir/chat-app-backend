package tn.vapex.domain.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.vapex.core.security.AuthFacade;
import tn.vapex.domain.api.mappers.MessageMapper;
import tn.vapex.domain.api.mappers.UserMapper;
import tn.vapex.domain.api.vm.ContactVM;
import tn.vapex.domain.entitites.Message;
import tn.vapex.domain.entitites.User;
import tn.vapex.domain.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthFacade authFacade;
    private final UserMapper userMapper;
    private final MessageMapper messageMapper;

    @GetMapping("")
    public ResponseEntity<List<ContactVM>> getContactList() {
        User authenticatedUser = this.authFacade.getAuthenticated();
        List<ContactVM> contacts = this.mapToContactVm(this.userService.getContactList(authenticatedUser));
        return ResponseEntity.ok(contacts);
    }

    private List<ContactVM> mapToContactVm(List<Pair<User, Message>> userMessagePairs) {
        return userMessagePairs.stream()
                .map(userMessagePair -> ContactVM.of(userMapper.toDto(userMessagePair.getFirst()), this.messageMapper.toDto(userMessagePair.getSecond())))
                .collect(Collectors.toList());
    }
}
