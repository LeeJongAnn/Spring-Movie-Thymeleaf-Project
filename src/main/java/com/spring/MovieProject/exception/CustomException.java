package com.spring.MovieProject.exception;

public abstract class CustomException extends RuntimeException {


    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int errorCode();


}
