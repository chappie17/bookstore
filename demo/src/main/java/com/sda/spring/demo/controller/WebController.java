package com.sda.spring.demo.controller;

import com.sda.spring.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", bookService.getBooks());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
