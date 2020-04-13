package com.piotrke.gameservice.exceptions;

import java.time.LocalDateTime;

public class BadRequestException extends BaseException {

    public BadRequestException(String code, String errorMessage) {
        super(code, errorMessage, LocalDateTime.now());
    }
}
