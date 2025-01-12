package com.bt.beertinder.service.impl;

import com.bt.beertinder.dto.PreferenceDTO;
import com.bt.beertinder.dto.UserProfileDTO;
import com.bt.beertinder.model.User;
import com.bt.beertinder.repository.UserRepository;
import com.bt.beertinder.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public UserProfileDTO getUserProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

        List<PreferenceDTO> preferences = user.getPreferences().stream()
                .map(preference -> new PreferenceDTO(
                        preference.getId(),
                        preference.getBeer().getName(),
                        preference.getLiked()
                ))
                .collect(Collectors.toList());

        return new UserProfileDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                preferences
        );
    }
}