package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AuthorRepository authorRepository;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String hello() {
//        return "Hello";
//    }
//
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public String test() {
//        return "This is test";
//    }

    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public List<Book> books() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @RequestMapping(value = "/api/categories", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }

    @RequestMapping(value = "/api/categories", method = RequestMethod.GET)
    public List<Category> categories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.GET)
    public List<Author> authors() {
        List<Author> authors = authorRepository.findAll();
        return authors;
    }

}
