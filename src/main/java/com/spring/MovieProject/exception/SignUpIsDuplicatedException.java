package com.spring.MovieProject.exception;

public class SignUpIsDuplicatedException extends CustomException{


    private static final String MESSAGE = "SignUp User Is Duplicated";
    public SignUpIsDuplicatedException() {
        super(MESSAGE);
    }


    @Override
    public int errorCode() {
        return 4000;
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
