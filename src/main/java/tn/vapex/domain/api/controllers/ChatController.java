package tn.vapex.domain.api.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.simp.broker.SimpleBrokerMessageHandler;
import org.springframework.web.bind.annotation.*;
import tn.vapex.core.security.AuthFacade;
import tn.vapex.domain.api.dtos.ConversationDto;
import tn.vapex.domain.api.dtos.MessageDto;
import tn.vapex.domain.api.mappers.ConversationMapper;
import tn.vapex.domain.api.mappers.MessageMapper;
import tn.vapex.domain.entitites.Conversation;
import tn.vapex.domain.entitites.Message;
import tn.vapex.domain.services.ChatService;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("chat")
@RequiredArgsConstructor
public class ChatController {
    private final ConversationMapper conversationMapper;
    private final ChatService chatService;
    private final MessageMapper messageMapper;
    private final AuthFacade authFacade;


    @GetMapping("conversation/{userId}")
    public ResponseEntity<ConversationDto> getConversation(@PathVariable @NotNull Long userId) {
        Conversation conversation = this.chatService.getConversationBetween(authFacade.getAuthenticated(), userId);
        return ResponseEntity.ok(this.conversationMapper.toDto(conversation));
    }

    @PostMapping("messages")
    public ResponseEntity<MessageDto> sendMessage(@RequestBody MessageDto messageDto) {
        Message message = this.chatService.sendMessage(this.authFacade.getAuthenticated(), messageDto.getRecipient().getId(), this.messageMapper.toEntity(messageDto));
        return ResponseEntity.ok(this.messageMapper.toDto(message));
    }
}
