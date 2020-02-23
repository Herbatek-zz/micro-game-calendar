package com.piotrke.user.dtos;

import lombok.Data;

@Data
public class UserRegistration {

    private String username;
    private String email;
    private String password;
}
