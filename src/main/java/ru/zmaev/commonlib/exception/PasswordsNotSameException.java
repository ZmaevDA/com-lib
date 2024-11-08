package ru.zmaev.commonlib.exception;

public class PasswordsNotSameException extends RuntimeException {
    public PasswordsNotSameException(String pass, String passRepeat) {
        super(String.format("Password %s does not match password %s", pass, passRepeat));
    }
}
