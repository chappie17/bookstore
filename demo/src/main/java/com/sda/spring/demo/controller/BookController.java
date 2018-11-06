package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.CategoryService;
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
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;

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
        return categoryService.addCategory(category);
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.GET)
    public List<Author> authors(){
        return authorService.getAuthors();
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
    public ResponseEntity <Book> book(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id));
    }

    @RequestMapping(value = "/api/categories/{id}", method = RequestMethod.GET)
    public ResponseEntity <Category> category (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findById(id));
    }

    @RequestMapping(value = "/api/authors/{id}", method = RequestMethod.GET)
    public ResponseEntity <Author> author (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(authorService.findById(id));
    }
}
