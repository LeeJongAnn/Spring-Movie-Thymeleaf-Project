package com.spring.MovieProject.exception;

public class UserNotFoundException extends Exception {


    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
