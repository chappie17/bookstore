package com.sda.spring.demo.service;

import com.sda.spring.demo.model.Book;
import com.sda.spring.demo.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @TestConfiguration
    public static class BookServiceTestConfig {
        @Bean
        public BookService bookService() {
            return new BookService();
        }
    }

    @MockBean
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        Book book = new Book("Java 5");
        Mockito.when(bookRepository.findByTitle(book.getTitle())).thenReturn(book);
    }

    @Test
    public void shouldCheckIfBookHasTheSameTitleWhatMockedObject(){
        String title = "Java 5";
        Book found = bookRepository.findByTitle(title);
        Assertions.assertThat(found.getTitle()).isEqualTo(title);
    }

}