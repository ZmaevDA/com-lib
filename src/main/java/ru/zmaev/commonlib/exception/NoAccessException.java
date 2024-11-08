package ru.zmaev.commonlib.exception;

import org.springframework.http.HttpStatus;

public class NoAccessException extends EntityException {
    private static final String MESSAGE = "User with username: '%s' and roles: '%s' does not have access to do this";
    public NoAccessException(String username, String roles) {
        super(HttpStatus.FORBIDDEN, String.format(MESSAGE, username, roles));
    }

    public NoAccessException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}
