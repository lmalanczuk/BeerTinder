package com.bt.beertinder.controller;

import com.bt.beertinder.dto.MatchDTO;
import com.bt.beertinder.model.Match;
import com.bt.beertinder.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<MatchDTO>> getMatchesForUser(@PathVariable Long userId) {
        return ResponseEntity.ok(matchService.getMatchesForUser(userId));
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestParam Long user1Id, @RequestParam Long user2Id) {
        return ResponseEntity.ok(matchService.createMatch(user1Id, user2Id));
    }
}
