package com.piotrke.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AuthProvider {
    LOCAL("local"),
    FACEBOOK("facebook"),
    GOOGLE("google");

    String value;
}
