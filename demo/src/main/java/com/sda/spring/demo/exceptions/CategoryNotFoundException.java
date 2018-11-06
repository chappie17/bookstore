package com.sda.spring.demo.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Long id) {
        super("There is no category on this id: " + id);
    }
}
