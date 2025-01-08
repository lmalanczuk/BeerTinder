package com.bt.beertinder.controller;

import com.bt.beertinder.service.PreferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {

    private final PreferenceService preferenceService;

    public PreferenceController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    @PostMapping
    public ResponseEntity<Void> addPreference(@RequestParam Long userId, @RequestParam Long beerId, @RequestParam Boolean liked) {
        preferenceService.addPreference(userId, beerId, liked);
        return ResponseEntity.noContent().build();
    }
}
