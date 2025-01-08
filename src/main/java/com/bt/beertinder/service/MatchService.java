package com.bt.beertinder.service;

import com.bt.beertinder.dto.MatchDTO;
import com.bt.beertinder.model.Match;
import java.util.List;

public interface MatchService {
    List<MatchDTO> getMatchesForUser(Long userId);
    Match createMatch(Long user1Id, Long user2Id);
}