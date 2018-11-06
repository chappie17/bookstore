package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import com.sda.spring.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public List<Book> books() {
        return bookService.getBooks();
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @RequestMapping(value = "/api/categories", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author) {
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

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
    public ResponseEntity <Book> book(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id));
    }

}
