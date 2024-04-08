package com.spring.MovieProject.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public final class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public ErrorResponse handleMemberException(CustomException exception, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();

        String message = exception.getMessage();
        int errorCode = exception.errorCode();
        errorResponse.setPath(request.getServletPath());
        errorResponse.setMessage(message);
        errorResponse.setCode(errorCode);

        return errorResponse;
    }

}