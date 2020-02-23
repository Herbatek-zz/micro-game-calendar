package com.piotrke.user.converter;

import com.piotrke.user.dtos.UserProfile;
import com.piotrke.user.dtos.UserRegistration;
import com.piotrke.user.entities.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {

    public static UserProfile toUserProfile(User user) {
        return UserProfile.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .imageUrl(user.getImageUrl())
                .build();
    }

    public static User toUser(UserRegistration userRegistration) {
        return User.builder()
                .username(userRegistration.getUsername())
                .password(userRegistration.getPassword())
                .email(userRegistration.getEmail())
                .build();
    }
}