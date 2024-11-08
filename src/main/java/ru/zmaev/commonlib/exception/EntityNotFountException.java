package ru.zmaev.commonlib.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFountException extends EntityException {
    private static final String MESSAGE = "Entity: '%s' with id '%s' does not exist!";

    public EntityNotFountException(String classNmae, Long id) {
        super(HttpStatus.NOT_FOUND, String.format(MESSAGE, classNmae, id));
    }

    public EntityNotFountException(String className, String id) {
        super(HttpStatus.NOT_FOUND, String.format(MESSAGE, className, id));
    }

    public EntityNotFountException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
