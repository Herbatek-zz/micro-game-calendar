package com.piotrke.user.services;

import com.piotrke.user.converter.UserConverter;
import com.piotrke.user.dtos.UserProfile;
import com.piotrke.user.dtos.UserRegistration;
import com.piotrke.user.entities.User;
import com.piotrke.user.exceptions.NotFoundException;
import com.piotrke.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserProfile findById(String id) {
        return userRepository.findById(id)
                .map(UserConverter::toUserProfile)
                .orElseThrow(() -> new NotFoundException("Not found user with id: " + id));
    }

    public UserProfile createUser(UserRegistration userRegistration) {
        User user = userRepository.save(UserConverter.toUser(userRegistration));
        return UserConverter.toUserProfile(user);
    }
}