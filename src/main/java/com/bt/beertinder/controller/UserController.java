package com.bt.beertinder.controller;

import com.bt.beertinder.model.User;
import com.bt.beertinder.model.Preference;
import com.bt.beertinder.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/{id}/preferences")
    public ResponseEntity<Void> addPreference(@PathVariable Long id, @RequestParam Long beerId, @RequestParam Boolean liked) {
        userService.addPreference(id, beerId, liked);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/preferences")
    public ResponseEntity<List<Preference>> getUserPreferences(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserPreferences(id));
    }
}
