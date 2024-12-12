package com.bt.beertinder.service.impl;

import com.bt.beertinder.model.Beer;
import com.bt.beertinder.model.Preference;
import com.bt.beertinder.model.PreferenceRequest;
import com.bt.beertinder.model.PreferenceResponse;
import com.bt.beertinder.model.User;
import com.bt.beertinder.repository.BeerRepository;
import com.bt.beertinder.repository.PreferenceRepository;
import com.bt.beertinder.repository.UserRepository;
import com.bt.beertinder.service.PreferenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private final BeerRepository beerRepository;
    private final UserRepository userRepository;

    public PreferenceServiceImpl(PreferenceRepository preferenceRepository, BeerRepository beerRepository, UserRepository userRepository){
        this.preferenceRepository = preferenceRepository;
        this.beerRepository = beerRepository;
        this.userRepository = userRepository;
    }

    public void savePreference(PreferenceRequest preferenceRequest) {
        User user = userRepository.findById(preferenceRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Beer beer = beerRepository.findById(preferenceRequest.getBeerId())
                .orElseThrow(() -> new RuntimeException("Beer not found"));

        Preference preference = preferenceRepository.findByUserAndBeer(user, beer)
                .orElse(Preference.builder()
                        .user(user)
                        .beer(beer)
                        .build());

        preference.setLiked(preferenceRequest.getLiked());
        preferenceRepository.save(preference);
    }

    public List<PreferenceResponse> getUserPreferences(Long userId) {
        return preferenceRepository.findByUserId(userId).stream()
                .map(pref -> new PreferenceResponse(pref.getBeer().getId(), pref.getBeer().getName(), pref.getLiked()))
                .toList();
    }

    public List<PreferenceResponse> getLikedBeers(Long userId) {
        return preferenceRepository.findByUserIdAndLiked(userId, true).stream()
                .map(pref -> new PreferenceResponse(
                        pref.getBeer().getId(),
                        pref.getBeer().getName(),
                        true // Wskazuje, że piwo jest polubione
                ))
                .toList();
    }

}
