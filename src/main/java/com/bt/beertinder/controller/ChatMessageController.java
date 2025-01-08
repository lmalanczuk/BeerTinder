//package com.bt.beertinder.controller;
//
//import com.bt.beertinder.model.ChatMessage;
//import com.bt.beertinder.service.ChatMessageService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/messages")
//public class ChatMessageController {
//
//    private final ChatMessageService chatMessageService;
//
//    public ChatMessageController(ChatMessageService chatMessageService) {
//        this.chatMessageService = chatMessageService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Void> saveMessage(@RequestParam Long chatRoomId, @RequestParam String sender, @RequestParam String content) {
//        chatMessageService.saveMessage(chatRoomId, sender, content);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/{chatRoomId}")
//    public ResponseEntity<List<ChatMessage>> getMessagesForRoom(@PathVariable Long chatRoomId) {
//        return ResponseEntity.ok(chatMessageService.getMessagesForRoom(chatRoomId));
//    }
//}