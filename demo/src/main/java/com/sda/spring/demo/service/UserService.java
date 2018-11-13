package com.sda.spring.demo.service;

import com.sda.spring.demo.interfaces.UserInterface;
import com.sda.spring.demo.model.User;
import com.sda.spring.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
