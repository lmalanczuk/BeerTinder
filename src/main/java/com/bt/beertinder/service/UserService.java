package com.bt.beertinder.service;

import com.bt.beertinder.model.User;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);
    User createUser(User user);
}
