package com.spring.MovieProject.exception;

public class ReplyErrorException extends CustomException {

    private final String MESSAGE = "Reply comments can not be null";

    public ReplyErrorException() {
        super();
    }

    public ReplyErrorException(String message) {
        super(message);
    }

    public ReplyErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public int errorCode() {
        return 6000;
    }
}
