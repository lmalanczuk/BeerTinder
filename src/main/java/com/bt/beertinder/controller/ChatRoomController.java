package com.bt.beertinder.controller;

import com.bt.beertinder.model.ChatRoom;
import com.bt.beertinder.service.ChatRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatrooms")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @PostMapping
    public ResponseEntity<ChatRoom> createRoom(@RequestParam Long user1Id, @RequestParam Long user2Id) {
        return ResponseEntity.ok(chatRoomService.createRoom(user1Id, user2Id));
    }
}
