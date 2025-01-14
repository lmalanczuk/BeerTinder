package com.bt.beertinder.controller;

import com.bt.beertinder.dto.ChatRoomDTO;
import com.bt.beertinder.model.ChatMessage;
import com.bt.beertinder.model.ChatRoom;
import com.bt.beertinder.service.ChatMessageService;
import com.bt.beertinder.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chatrooms")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;

    @Autowired
    public ChatRoomController(ChatRoomService chatRoomService, ChatMessageService chatMessageService) {
        this.chatRoomService = chatRoomService;
        this.chatMessageService = chatMessageService;
    }

    @PostMapping
public ResponseEntity<ChatRoomDTO> createRoom(@RequestParam Long user1Id, @RequestParam Long user2Id) {
    ChatRoom chatRoom = chatRoomService.createRoom(user1Id, user2Id);
    ChatRoomDTO chatRoomDTO = chatRoomService.mapToDTO(chatRoom);
    return ResponseEntity.ok(chatRoomDTO);
}


    @GetMapping("/{chatRoomId}/messages")
    public ResponseEntity<List<ChatMessage>> getMessagesForRoom(@PathVariable Long chatRoomId,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        List<ChatMessage> messages = chatMessageService.getMessagesForRoom(chatRoomId, page, size);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ChatRoomDTO>> getUserChatRooms(@PathVariable Long userId) {
        List<ChatRoom> chatRooms = chatRoomService.getChatRoomsForUser(userId);
        List<ChatRoomDTO> chatRoomDTOs = chatRooms.stream()
                .map(chatRoomService::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(chatRoomDTOs);
    }

}
