package com.bt.beertinder.service.impl;

import com.bt.beertinder.controller.PreferenceController;
import com.bt.beertinder.dto.BeerDTO;
import com.bt.beertinder.model.Beer;
import com.bt.beertinder.model.Preference;
import com.bt.beertinder.model.User;
import com.bt.beertinder.repository.BeerRepository;
import com.bt.beertinder.repository.PreferenceRepository;
import com.bt.beertinder.repository.UserRepository;
import com.bt.beertinder.service.PreferenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Beer beer = beerRepository.findById(beerId)
                .orElseThrow(() -> new RuntimeException("Beer not found"));

        List<Preference> existingPreferences = preferenceRepository.findByUserAndBeer(user, beer);

        if (!existingPreferences.isEmpty()) {
            // Aktualizujemy tylko pierwszą preferencję (zakładając, że nie chcemy duplikatów)
            Preference preference = existingPreferences.get(0);
            preference.setLiked(liked);
            preferenceRepository.save(preference);
        } else {
            // Jeśli nie ma jeszcze preferencji, tworzymy nową
            Preference preference = new Preference();
            preference.setUser(user);
            preference.setBeer(beer);
            preference.setLiked(liked);
            preferenceRepository.save(preference);
        }
    }


    public List<BeerDTO> getLikedBeers(Long userId) {
        List<Preference> likedPreferences = preferenceRepository.findByUserIdAndLiked(userId, true);
        return likedPreferences.stream()
                .map(pref -> new BeerDTO(pref.getBeer().getId(), pref.getBeer().getName(), pref.getBeer().getDescription(), pref.getBeer().getImageUrl()))
                .collect(Collectors.toList());
    }

    public void removePreference(Long userId, Long beerId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Beer beer = beerRepository.findById(beerId)
                .orElseThrow(() -> new RuntimeException("Beer not found"));

        List<Preference> preferences = preferenceRepository.findByUserAndBeer(user, beer);

        if (!preferences.isEmpty()) {
            preferenceRepository.delete(preferences.get(0)); // Usuwamy pierwsze wystąpienie
            System.out.println("Preference removed: User " + userId + " - Beer " + beerId);
        } else {
            System.out.println("No preference found for user " + userId + " and beer " + beerId);
        }
    }

}
