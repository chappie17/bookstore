package com.sda.spring.demo.component;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ExampleList {

    public ExampleList() {
        System.out.println("===INFO===");
    }

    public String generate(){
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Random random = new Random();
        int i = random.nextInt(list.size());

        return list.get(i);
    }

}
