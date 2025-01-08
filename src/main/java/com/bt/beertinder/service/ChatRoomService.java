package com.bt.beertinder.service;

import com.bt.beertinder.model.ChatRoom;

public interface ChatRoomService {
    ChatRoom createRoom(Long user1Id, Long user2Id);
}