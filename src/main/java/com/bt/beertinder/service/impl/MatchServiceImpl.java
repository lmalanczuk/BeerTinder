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
import java.util.Optional;
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
    Optional<Match> existingMatch = matchRepository.findByUser1IdAndUser2IdOrUser2IdAndUser1Id(user1Id, user2Id, user1Id, user2Id);
    if (existingMatch.isPresent()) {
        throw new RuntimeException("Match already exists");
    }

    User user1 = userRepository.findById(user1Id).orElseThrow(() -> new RuntimeException("User not found"));
    User user2 = userRepository.findById(user2Id).orElseThrow(() -> new RuntimeException("User not found"));

    Match match = Match.builder()
            .user1(user1)
            .user2(user2)
            .matchedAt(LocalDateTime.now())
            .build();

    return matchRepository.save(match);
}

}
