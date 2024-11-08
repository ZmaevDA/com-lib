package ru.zmaev.commonlib.exception;

import org.springframework.http.HttpStatus;

public class EntityBadRequestException extends EntityException {
    public EntityBadRequestException(String errorMessage) {
        super(HttpStatus.BAD_REQUEST, errorMessage);
    }
}
