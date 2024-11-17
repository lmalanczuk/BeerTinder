package com.bt.beertinder.service.impl;

import com.bt.beertinder.model.User;
import com.bt.beertinder.model.Beer;
import com.bt.beertinder.model.Preference;
import com.bt.beertinder.repository.UserRepository;
import com.bt.beertinder.repository.BeerRepository;
import com.bt.beertinder.repository.PreferenceRepository;
import com.bt.beertinder.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BeerRepository beerRepository;
    private final PreferenceRepository preferenceRepository;

    public UserServiceImpl(UserRepository userRepository, BeerRepository beerRepository, PreferenceRepository preferenceRepository) {
        this.userRepository = userRepository;
        this.beerRepository = beerRepository;
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void addPreference(Long userId, Long beerId, Boolean liked) {
        User user = getUserById(userId);
        Beer beer = beerRepository.findById(beerId)
                .orElseThrow(() -> new IllegalArgumentException("Beer not found with id: " + beerId));

        Preference preference = Preference.builder()
                .user(user)
                .beer(beer)
                .liked(liked)
                .build();

        preferenceRepository.save(preference);
    }

    @Override
    public List<Preference> getUserPreferences(Long userId) {
        return preferenceRepository.findByUserIdAndLiked(userId, true);
    }
}
