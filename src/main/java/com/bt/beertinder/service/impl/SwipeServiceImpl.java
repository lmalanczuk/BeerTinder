package com.bt.beertinder.service.impl;

import com.bt.beertinder.dto.UserSwipeDTO;
import com.bt.beertinder.model.Match;
import com.bt.beertinder.model.User;
import com.bt.beertinder.repository.MatchRepository;
import com.bt.beertinder.repository.UserRepository;
import com.bt.beertinder.service.SwipeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SwipeServiceImpl implements SwipeService{

    private final UserRepository userRepository;
    private final MatchRepository matchRepository;

    public SwipeServiceImpl(UserRepository userRepository, MatchRepository matchRepository) {
        this.userRepository = userRepository;
        this.matchRepository = matchRepository;
    }

    public UserSwipeDTO processSwipe(Long userId, Long targetUserId, Boolean liked) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        User targetUser = userRepository.findById(targetUserId)
                .orElseThrow(() -> new IllegalArgumentException("Target user not found with ID: " + targetUserId));

        if (liked) {
            Optional<Match> existingMatch = matchRepository.findByUser1IdAndUser2IdOrUser2IdAndUser1Id(userId, targetUserId, targetUserId, userId);
            if (existingMatch.isEmpty()) {
                Match match = Match.builder()
                        .user1(user)
                        .user2(targetUser)
                        .matchedAt(LocalDateTime.now())
                        .build();
                matchRepository.save(match);
            }
        }

        return new UserSwipeDTO(userId, targetUserId, liked);
    }
}
