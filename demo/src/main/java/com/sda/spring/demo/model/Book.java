package com.sda.spring.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 100, message = "from 1 to 100 marks")
    private String title;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Category category;

    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Author> authors;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}
