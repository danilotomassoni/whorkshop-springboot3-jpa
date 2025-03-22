package com.curse.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curse.demo.models.Category;
import com.curse.demo.models.Order;
import com.curse.demo.models.OrderItem;
import com.curse.demo.models.Product;
import com.curse.demo.models.User;
import com.curse.demo.models.enums.OrderStatus;
import com.curse.demo.repositories.CategoryRepository;
import com.curse.demo.repositories.OrderItemRepository;
import com.curse.demo.repositories.OrderRepository;
import com.curse.demo.repositories.ProductRepository;
import com.curse.demo.repositories.UserRepository;

@SpringBootTest
public class ConfigTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    public void insertTest(){

        User u1 = new User(null, "JOÃO", "joao@gmail.com", "55231233333", "12343");
        User u2 = new User(null, "MARIA", "maria@gmail.com", "55231244444", "12344");
        
        Order o1 = new Order(null, Instant.now(), OrderStatus.PAID, u2);
        Order o2 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, u1);
        Order o3 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, u2);

        Category cat1 = new Category(null,"ELECTRONICS"); 
        Category cat2 = new Category(null,"BOOKS"); 
        Category cat3 = new Category(null,"COMPUTERS");

        Product p1 = new Product(null,"The Lord","",90.0,"");
        Product p2 = new Product(null,"Smart TV","",2190.0,"");
        Product p3 = new Product(null,"Macbook Pro","",1250.0,"");
        Product p4 = new Product(null,"PC Gamer","",100.0,"");
        Product p5 = new Product(null,"Rails","",99.0,"");

        p1.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat2);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat3);


        OrderItem or1 = new OrderItem(o1,p1,2,p1.getPrice());
        OrderItem or2 = new OrderItem(o1,p2,2,p2.getPrice());
        OrderItem or3 = new OrderItem(o2,p3,2,p3.getPrice());
        OrderItem or4 = new OrderItem(o3,p4,2,p4.getPrice());
        OrderItem or5 = new OrderItem(o3,p5,2,p5.getPrice());
        
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        orderItemRepository.saveAll(Arrays.asList(or1,or2,or3,or4,or5));

    }

}
