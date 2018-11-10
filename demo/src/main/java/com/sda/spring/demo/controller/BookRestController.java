package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;

    @CrossOrigin(value = "http://localhost:8000")
    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public List<Book> books() {
        return bookService.getBooks();
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
    }

    @CrossOrigin(value = "http://localhost:8000")
    @RequestMapping(value = "/api/categories", method = RequestMethod.POST)
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(category));
    }

    @CrossOrigin(value = "http://localhost:8000")
    @RequestMapping(value = "/api/authors", method = RequestMethod.POST)
    public ResponseEntity <Author> addAuthor(@Valid @RequestBody Author author) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.addAuthor(author));
    }

    @RequestMapping(value = "/api/categories", method = RequestMethod.GET)
    public List <Category>categories(){
        return categoryService.getCategories();
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

    @RequestMapping(value = "/api/categories/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoryService.updateCategory(id, category));
    }
}
