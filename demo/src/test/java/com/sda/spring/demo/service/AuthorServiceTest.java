package com.sda.spring.demo.service;

import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.repository.AuthorRepository;
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
public class AuthorServiceTest {

    @Autowired
    AuthorService authorService;

    @TestConfiguration
    public static class AuthorServiceTestCongfig {
        @Bean
        public AuthorService authorService() {
            return new AuthorService();
        }
    }

    @MockBean
    private AuthorRepository authorRepository;

    @Before
    public void setUp(){
        Author author = new Author("Jane", "Austin");
        Mockito.when(authorRepository.findByName(author.getName())).thenReturn(author);
        Mockito.when(authorRepository.findByLastname(author.getLastname())).thenReturn(author);
    }

    @Test
    public void shouldCheckTheNameAndLastnemeIsTheSameForMockingObject(){
        String name = "Jane";
        String lastname = "Austin";
        Author foundAuthorName = authorRepository.findByName(name);
        Author foundAuthorLastname = authorRepository.findByLastname(lastname);

        Assertions.assertThat(foundAuthorName.getName()).isEqualTo(name);
        Assertions.assertThat(foundAuthorLastname.getLastname()).isEqualTo(lastname);
    }
}