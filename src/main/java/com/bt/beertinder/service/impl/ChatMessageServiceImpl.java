package com.bt.beertinder.service.impl;

import com.bt.beertinder.model.ChatMessage;
import com.bt.beertinder.model.ChatRoom;
import com.bt.beertinder.repository.ChatMessageRepository;
import com.bt.beertinder.repository.ChatRoomRepository;
import com.bt.beertinder.service.ChatMessageService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;

    public ChatMessageServiceImpl(ChatMessageRepository chatMessageRepository, ChatRoomRepository chatRoomRepository) {
        this.chatMessageRepository = chatMessageRepository;
        this.chatRoomRepository = chatRoomRepository;
    }

    @Override
    public void saveMessage(Long chatRoomId, String sender, String content) {
        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId).orElseThrow(() -> new IllegalArgumentException("Chat room not found with id: " + chatRoomId));

        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(chatRoom)
                .sender(sender)
                .content(content)
                .timestamp(LocalDateTime.now())
                .build();

        chatMessageRepository.save(chatMessage);
    }

    @Override
    public List<ChatMessage> getMessagesForRoom(Long chatRoomId) {
        return chatMessageRepository.findByChatRoomId(chatRoomId);
    }
}