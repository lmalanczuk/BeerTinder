package com.bt.beertinder.controller;

import com.bt.beertinder.model.Preference;
import com.bt.beertinder.model.PreferenceRequest;
import com.bt.beertinder.model.PreferenceResponse;
import com.bt.beertinder.service.PreferenceService;
import org.apache.coyote.Response;
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

    //zapisywanie lub edytowanie preferencji uzytkownika
    @PostMapping
    public ResponseEntity<Void> savePreference(@RequestBody PreferenceRequest preferenceRequest){
        preferenceService.savePreference(preferenceRequest);
        return ResponseEntity.ok().build();
    }

    //pobieranie wszystkich preferencji uzytkownika
    @GetMapping("/{userId}")
    public ResponseEntity<List<PreferenceResponse>> getUserPreferences(@PathVariable Long userId) {
        return ResponseEntity.ok(preferenceService.getUserPreferences(userId));
    }

    @GetMapping("/liked/{userId}")
    public ResponseEntity<List<PreferenceResponse>> getLikedBeers(@PathVariable Long userId) {
        List<PreferenceResponse> likedBeers = preferenceService.getLikedBeers(userId);
        return ResponseEntity.ok(likedBeers);
    }
}
