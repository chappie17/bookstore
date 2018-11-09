package com.sda.spring.demo;

import com.sda.spring.demo.model.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() throws Exception {
        // given
        Person person = applicationContext.getBean(Person.class);
        // when

        // then
        Assertions.assertThat(person.getName()).isEqualTo("HUMAN");
    }

}