package com.bt.beertinder.controller;

import com.bt.beertinder.dto.UserProfileDTO;
import com.bt.beertinder.model.User;
import com.bt.beertinder.service.CurrentUserService;
import com.bt.beertinder.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final CurrentUserService currentUserService;

    public UserController(UserService userService, CurrentUserService currentUserService) {
        this.userService = userService;
        this.currentUserService = currentUserService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{userId}/profile")
    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable Long userId) {
        UserProfileDTO userProfile = userService.getUserProfile(userId);
        return ResponseEntity.ok(userProfile);
    }

    @GetMapping("/current/profile")
    public ResponseEntity<UserProfileDTO> getCurrentUserProfile() {
        UserProfileDTO userProfile = currentUserService.getCurrentUserProfile();
        return ResponseEntity.ok(userProfile);
    }
    @GetMapping("/current/username")
    public String getCurrentUsername() {
        return currentUserService.getCurrentUsername();
    }
}