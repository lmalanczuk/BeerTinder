package com.bt.beertinder.controller;

import com.bt.beertinder.model.User;
import com.bt.beertinder.service.MatchingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/matching")
public class MatchingController {

    private final MatchingService matchingService;

    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @GetMapping("/groups")
    public ResponseEntity<Map<String, List<User>>> groupUsersByBeer() {
        return ResponseEntity.ok(matchingService.groupUsersByBeer());
    }

    @GetMapping("/subgroups")
    public ResponseEntity<List<List<User>>> createSubgroups() {
        Map<String, List<User>> groups = matchingService.groupUsersByBeer();
        return ResponseEntity.ok(matchingService.createSubgroups(groups));
    }

    @GetMapping("/pairs")
    public ResponseEntity<List<List<User>>> pairUsers() {
        Map<String, List<User>> groups = matchingService.groupUsersByBeer();
        List<List<User>> subgroups = matchingService.createSubgroups(groups);
        return ResponseEntity.ok(matchingService.pairUsers(subgroups));
    }
}
