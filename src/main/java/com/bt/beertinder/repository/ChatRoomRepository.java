package com.bt.beertinder.repository;

import com.bt.beertinder.model.ChatRoom;
import com.bt.beertinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    Optional<ChatRoom> findByParticipantsContainsAndParticipantsContains(User user1, User user2);
}
