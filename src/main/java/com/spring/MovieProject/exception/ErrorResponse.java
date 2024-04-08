package com.spring.MovieProject.exception;

public class ErrorResponse {

    private String path;

    private int code;

    private String message;

    public String getPath() {
        return path;
    }

    public void setPath(String status) {
        this.path = status;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
