package com.bt.beertinder.service.impl;

import com.bt.beertinder.dto.ChatRoomDTO;
import com.bt.beertinder.model.ChatRoom;
import com.bt.beertinder.model.User;
import com.bt.beertinder.repository.ChatRoomRepository;
import com.bt.beertinder.repository.UserRepository;
import com.bt.beertinder.service.ChatRoomService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository, UserRepository userRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ChatRoom createRoom(Long user1Id, Long user2Id) {
        User user1 = userRepository.findById(user1Id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + user1Id));
        User user2 = userRepository.findById(user2Id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + user2Id));

        ChatRoom chatRoom = ChatRoom.builder()
                .participants(List.of(user1, user2))
                .build();

        return chatRoomRepository.save(chatRoom);
    }

    public ChatRoomDTO mapToDTO(ChatRoom chatRoom) {
        return new ChatRoomDTO(
                chatRoom.getId(),
                chatRoom.getParticipants().stream()
                        .map(User::getId)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public List<ChatRoom> getChatRoomsForUser(Long userId) {
        return chatRoomRepository.findChatRoomsByUserId(userId);
    }

}


