package ru.zmaev.commonlib.exception;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class EntityException extends RuntimeException {
    private final int errorCode;
    private final HttpStatus status;
    private final String errorMessage;
    private final Instant instant;

    protected EntityException(HttpStatus httpStatus, String errorMessage) {
        this.errorCode = httpStatus.value();
        this.status = httpStatus;
        this.errorMessage = errorMessage;
        this.instant = Instant.now();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getInstant() {
        return instant.toString();
    }
}