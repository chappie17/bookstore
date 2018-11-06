package com.sda.spring.demo.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("There is no book by this id: " + id);
    }


}
