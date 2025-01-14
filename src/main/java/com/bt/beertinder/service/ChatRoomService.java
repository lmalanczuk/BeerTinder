package com.bt.beertinder.service;

import com.bt.beertinder.dto.ChatRoomDTO;
import com.bt.beertinder.model.ChatRoom;

import java.util.List;

public interface ChatRoomService {
    ChatRoom createRoom(Long user1Id, Long user2Id);
    ChatRoomDTO mapToDTO(ChatRoom chatRoom);
    List<ChatRoom> getChatRoomsForUser(Long userId);

}