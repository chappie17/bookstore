package com.sda.spring.demo.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {

    private HttpStatus status;
    private String message;
    private List <String> errors;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy hh:mm:ss")
    private LocalDateTime localDateTime;

    public ApiError(HttpStatus status, String message, List<String> errors, LocalDateTime localDateTime) {
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.localDateTime = localDateTime;
    }

    public HttpStatus getStatus() {
        return status;
    }


    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
