package com.exen.testTask.exception;

public class UserExistingEmailException extends RuntimeException {
    public UserExistingEmailException(String message) {
        super(message);
    }

    public UserExistingEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}