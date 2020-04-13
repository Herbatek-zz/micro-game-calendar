package com.piotrke.gameservice.exceptions;

import java.time.LocalDateTime;

public class NotFoundException extends BaseException {

    public NotFoundException(String code, String errorMessage) {
        super(code, errorMessage, LocalDateTime.now());
    }
}
