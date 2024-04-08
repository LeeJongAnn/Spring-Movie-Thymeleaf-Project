package com.spring.MovieProject.exception;

public class UserNotFoundException extends CustomException {

    private final String MESSAGE = "User not found";

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException() {
        super();
    }

    @Override
    public int errorCode() {
        return 4001;
    }
}
