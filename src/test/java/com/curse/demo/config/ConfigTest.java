package com.curse.demo.config;

import java.util.Arrays;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curse.demo.models.User;
import com.curse.demo.repositories.UserRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ConfigTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    public void insertUserTest(){
        User u1 = new User(null, "JOÃO", "joao@gmail.com", "55231233333", "12343");
        User u2 = new User(null, "MARIA", "maria@gmail.com", "55231244444", "12344");
        userRepository.saveAll(Arrays.asList(u1,u2));    
    }

}
