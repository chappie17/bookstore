package com.sda.spring.demo.exceptions;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(Long id) {
        super("There is no author by this id: " + id);
    }
}
