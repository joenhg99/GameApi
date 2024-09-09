package com.example.game_service_api.commons.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GameException extends RuntimeException{
    private HttpStatus httpStatus;

    public GameException(final HttpStatus httpStatus, final String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
