package com.bt.beertinder.service.impl;

import com.bt.beertinder.model.Beer;
import com.bt.beertinder.model.Preference;
import com.bt.beertinder.model.User;
import com.bt.beertinder.repository.BeerRepository;
import com.bt.beertinder.repository.PreferenceRepository;
import com.bt.beertinder.repository.UserRepository;
import com.bt.beertinder.service.PreferenceService;
import org.springframework.stereotype.Service;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    private final UserRepository userRepository;
    private final BeerRepository beerRepository;
    private final PreferenceRepository preferenceRepository;

    public PreferenceServiceImpl(UserRepository userRepository, BeerRepository beerRepository, PreferenceRepository preferenceRepository) {
        this.userRepository = userRepository;
        this.beerRepository = beerRepository;
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public void addPreference(Long userId, Long beerId, Boolean liked) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        Beer beer = beerRepository.findById(beerId).orElseThrow(() -> new IllegalArgumentException("Beer not found with id: " + beerId));

        Preference preference = Preference.builder()
                .user(user)
                .beer(beer)
                .liked(liked)
                .build();

        preferenceRepository.save(preference);
    }
}
