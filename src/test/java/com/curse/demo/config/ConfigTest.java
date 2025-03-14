package com.curse.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curse.demo.models.User;
import com.curse.demo.repositories.UserRepository;

import com.curse.demo.repositories.OrderRepository;
import com.curse.demo.models.Order;
import com.curse.demo.models.enums.OrderStatus;

@SpringBootTest
public class ConfigTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void insertUserTest(){
        User u1 = new User(null, "JOÃO", "joao@gmail.com", "55231233333", "12343");
        User u2 = new User(null, "MARIA", "maria@gmail.com", "55231244444", "12344");
        
        Order o1 = new Order(null, Instant.now(), OrderStatus.PAID, u2);
        Order o2 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, u1);
        Order o3 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, u2);
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }

}
