package com.piotrke.user.controllers;

import com.piotrke.user.dtos.UserRegistration;
import com.piotrke.user.services.UserService;
import com.piotrke.user.dtos.UserProfile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> findById(@PathVariable String id) {
        log.info("Find UserProfile by id: {}", id);
        UserProfile userProfile = userService.findById(id);
        log.info("Successfully returned UserProfile: {}", userProfile);
        return ResponseEntity.ok(userProfile);
    }

    @PostMapping
    public ResponseEntity<UserProfile> createUser(UserRegistration userRegistration) {
        log.info("Create a new userRegistration: {}", userRegistration.getUsername());
        UserProfile user = userService.createUser(userRegistration);
        return ResponseEntity
                .created(URI.create("/api/users/" + user.getId()))
                .body(user);
    }

    @PostMapping("/{id}/verify/{token}")
    public ResponseEntity<Void> verifyEmail(@PathVariable String id, @PathVariable String token) {
        log.info("Verify email for user: {}", id);
        return ResponseEntity.ok().build();
    }
}
