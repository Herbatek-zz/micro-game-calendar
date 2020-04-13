package com.piotrke.gameservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseException extends RuntimeException {
    private String code;
    private String errorMessage;
    private LocalDateTime localDateTime;
}
