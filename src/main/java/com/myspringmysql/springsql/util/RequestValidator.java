package com.myspringmysql.springsql.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RequestValidator {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorHandler handleInvalidRequestData(MethodArgumentNotValidException exception) {
        var errorList = exception.getBindingResult().getFieldErrors().stream().map(
                message ->  message.getField() +":"+message.getDefaultMessage()
        ).collect(Collectors.joining(", "));
        return new ErrorHandler(errorList);
    }
}
