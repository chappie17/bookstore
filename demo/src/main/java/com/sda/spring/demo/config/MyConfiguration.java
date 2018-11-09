package com.sda.spring.demo.config;

import com.sda.spring.demo.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public Person personBean(){
        return new Person();
    }
}
