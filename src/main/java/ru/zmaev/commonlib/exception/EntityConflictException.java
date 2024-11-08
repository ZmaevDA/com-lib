package ru.zmaev.commonlib.exception;

import org.springframework.http.HttpStatus;

public class EntityConflictException extends EntityException {

    private static final String MESSAGE = "Entity '%s' with id: '%s' already exists!";

    public EntityConflictException(String className, String id) {
        super(HttpStatus.CONFLICT, String.format(MESSAGE, className, id));
    }

    public EntityConflictException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
