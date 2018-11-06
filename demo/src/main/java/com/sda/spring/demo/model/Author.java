package com.sda.spring.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 20, message = "from 2 to 20 marks")
    private String name;
    @NotNull
    @Size(min = 2, max = 20, message = "from 2 to 20 marks")
    private String lastname;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
