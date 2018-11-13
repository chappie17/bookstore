package com.sda.spring.demo;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.model.Person;
import com.sda.spring.demo.repository.AuthorRepository;
import com.sda.spring.demo.repository.BookRepository;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Person person;

    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public DemoApplication(BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Person person = applicationContext.getBean(Person.class);
//        person.setName("HUMAN");
//        System.out.println(person.getName());
//
//        Set<Author> authors = new HashSet<>();
//        authors.add(new Author("Bob", "Singer"));
//        Book book0 = new Book("Supernatural");
//        book0.setCategory(new Category("Fantasy"));
//        book0.setAuthors(authors);
//        bookRepository.save(book0);
    }

}

