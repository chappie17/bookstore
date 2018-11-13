package com.sda.spring.demo.controller;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.model.User;
import com.sda.spring.demo.service.AuthorService;
import com.sda.spring.demo.service.BookService;
import com.sda.spring.demo.service.CategoryService;
import com.sda.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", bookService.getBooks());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/category")
    public ModelAndView category(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("category");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping(value = "category")
    public void addCategory (@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        System.out.println(category.toString());
    }

    @PostMapping(value = "author")
    public void addAuthor (@ModelAttribute("author") Author author){
        authorService.addAuthor(author);
        System.out.println(author.toString());
    }

    @GetMapping(value = "/author")
    public ModelAndView author(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("author");
        modelAndView.addObject("author", new Author());
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView user(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("register", new User());
        return modelAndView;
    }

    @PostMapping(value = "register")
    public void addUser(@ModelAttribute("register") User user){
       userService.addUser(user);
    }
}
