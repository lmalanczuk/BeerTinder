package com.bt.beertinder.service.impl;

import com.bt.beertinder.dto.MatchDTO;
import com.bt.beertinder.model.Match;
import com.bt.beertinder.model.User;
import com.bt.beertinder.repository.MatchRepository;
import com.bt.beertinder.repository.UserRepository;
import com.bt.beertinder.service.MatchService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final UserRepository userRepository;

    public MatchServiceImpl(MatchRepository matchRepository, UserRepository userRepository) {
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<MatchDTO> getMatchesForUser(Long userId) {
        List<Match> matches = matchRepository.findMatchesForUser(userId);
        return matches.stream()
                .map(match -> MatchDTO.builder()
                        .id(match.getId())
                        .matchedAt(match.getMatchedAt())
                        .user1Name(match.getUser1().getUsername())
                        .user2Name(match.getUser2().getUsername())
                        .build())
                .collect(Collectors.toList()
                );

    }

    @Override
    public Match createMatch(Long user1Id, Long user2Id) {
        User user1 = userRepository.findById(user1Id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + user1Id));
        User user2 = userRepository.findById(user2Id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + user2Id));

        Match match = Match.builder()
                .user1(user1)
                .user2(user2)
                .matchedAt(LocalDateTime.now())
                .build();

        return matchRepository.save(match);
    }
}
