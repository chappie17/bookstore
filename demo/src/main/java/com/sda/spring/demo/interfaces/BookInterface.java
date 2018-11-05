package com.sda.spring.demo.interfaces;

import com.sda.spring.demo.model.Book;

import java.util.List;

public interface BookInterface {

    List<Book> getBooks();

    Book addBook(Book book);

    Book findById(Long id);

    Book findByTitle (String title);

    void delete(Long id);
}
