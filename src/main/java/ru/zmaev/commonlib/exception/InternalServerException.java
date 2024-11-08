package ru.zmaev.commonlib.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends EntityException {
    public InternalServerException(String errorMessage) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage);
    }
}
