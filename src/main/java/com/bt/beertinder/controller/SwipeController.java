package com.bt.beertinder.controller;

import com.bt.beertinder.dto.UserSwipeDTO;
import com.bt.beertinder.model.Match;
import com.bt.beertinder.service.MatchService;
import com.bt.beertinder.service.SwipeService;
import com.bt.beertinder.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/swipe")
public class SwipeController {

    private final SwipeService swipeService;

    public SwipeController(SwipeService swipeService) {
        this.swipeService = swipeService;
    }

    @PostMapping
    public ResponseEntity<UserSwipeDTO> swipeUser(@RequestParam Long userId, @RequestParam Long targetUserId, @RequestParam Boolean liked) {
        UserSwipeDTO swipeResult = swipeService.processSwipe(userId, targetUserId, liked);
        return ResponseEntity.ok(swipeResult);
    }
}
