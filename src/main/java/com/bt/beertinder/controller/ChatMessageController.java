package com.bt.beertinder.controller;

import com.bt.beertinder.model.ChatMessage;
import com.bt.beertinder.service.ChatMessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    public ChatMessageController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @GetMapping("/{chatRoomId}")
    public ResponseEntity<List<ChatMessage>> getMessagesForRoom(
            @PathVariable Long chatRoomId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<ChatMessage> messages = chatMessageService.getMessagesForRoom(chatRoomId, page, size);
        return ResponseEntity.ok(messages);
    }

    @PostMapping("/{chatRoomId}")
    public ResponseEntity<Void> sendMessage(
            @PathVariable Long chatRoomId,
            @RequestBody ChatMessage chatMessage) {
        chatMessageService.saveMessage(chatRoomId, chatMessage.getSender(), chatMessage.getContent());
        return ResponseEntity.ok().build();
    }
}
