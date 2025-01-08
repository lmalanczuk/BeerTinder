package com.bt.beertinder.service;

import com.bt.beertinder.model.ChatMessage;
import java.util.List;

public interface ChatMessageService {
    void saveMessage(Long chatRoomId, String sender, String content);
    List<ChatMessage> getMessagesForRoom(Long chatRoomId);
}