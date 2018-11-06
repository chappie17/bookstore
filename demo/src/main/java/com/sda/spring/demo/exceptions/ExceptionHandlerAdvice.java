package com.sda.spring.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity handleException(BookNotFoundException e){
       return ResponseEntity
               .status(HttpStatus.NOT_FOUND)
               .body(new ApiError(HttpStatus.NOT_FOUND, "There is no results",
                       Arrays.asList("id"),
                       LocalDateTime.now()));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity handleException(CategoryNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiError(HttpStatus.NOT_FOUND,"There is no results",
                        Arrays.asList("id"),
                        LocalDateTime.now()));
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity handleException(AuthorNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiError(HttpStatus.NOT_FOUND, "There is no results",
                        Arrays.asList("id"),
                        LocalDateTime.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity inputHandleException(MethodArgumentNotValidException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ValidationsError(HttpStatus.BAD_REQUEST,
                        e.getBindingResult().getAllErrors()));
    }
}
