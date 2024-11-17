package com.bt.beertinder.service;

import com.bt.beertinder.model.User;
import com.bt.beertinder.model.Preference;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    void addPreference(Long userId, Long beerId, Boolean liked);

    List<Preference> getUserPreferences(Long userId);
}
