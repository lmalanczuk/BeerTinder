package com.bt.beertinder.controller;

import com.bt.beertinder.model.Match;
import com.bt.beertinder.service.MatchService;
import com.bt.beertinder.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/swipe")
public class SwipeController {

    private final UserService userService;
    private final MatchService matchService;

    public SwipeController(UserService userService, MatchService matchService) {
        this.userService = userService;
        this.matchService = matchService;
    }

    @PostMapping
    public ResponseEntity<Match> swipeUser(@RequestParam Long userId, @RequestParam Long targetUserId, @RequestParam Boolean liked) {
        if (liked) {
            Match potentialMatch = matchService.createMatch(userId, targetUserId);
            return ResponseEntity.ok(potentialMatch);
        }
        return ResponseEntity.noContent().build();
    }
}