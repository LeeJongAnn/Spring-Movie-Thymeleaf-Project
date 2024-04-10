package com.spring.MovieProject.exception;

public class BoardNotFoundException extends CustomException {


    public BoardNotFoundException() {
        super();
    }

    public BoardNotFoundException(String message) {
        super(message);
    }

    public BoardNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public int errorCode() {
        return 3000;
    }
}
