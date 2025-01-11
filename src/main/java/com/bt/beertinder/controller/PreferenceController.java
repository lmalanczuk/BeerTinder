package com.bt.beertinder.controller;

import com.bt.beertinder.dto.BeerDTO;
import com.bt.beertinder.dto.SwipeRequest;
import com.bt.beertinder.model.Beer;
import com.bt.beertinder.service.PreferenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {

    private final PreferenceService preferenceService;

    public PreferenceController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addPreference(@RequestBody SwipeRequest swipeRequest) {
        try {
            System.out.println("Received request: " + swipeRequest);
            preferenceService.addPreference(swipeRequest.getUserId(), swipeRequest.getBeerId(), swipeRequest.isLiked());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace(); // Wypisuje pełny stacktrace do logów backendu
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{userId}/liked")
    public ResponseEntity<List<BeerDTO>> getLikedBeers(@PathVariable Long userId) {
        try {
            System.out.println("Fetching liked beers for user: " + userId);
            List<BeerDTO> likedBeers = preferenceService.getLikedBeers(userId);
            return ResponseEntity.ok(likedBeers);
        } catch (Exception e) {
            e.printStackTrace(); // 📌 Wypisze pełny błąd w logach backendu
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{userId}/remove/{beerId}")
    public ResponseEntity<Void> removePreference(@PathVariable Long userId, @PathVariable Long beerId) {
        try {
            preferenceService.removePreference(userId, beerId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

