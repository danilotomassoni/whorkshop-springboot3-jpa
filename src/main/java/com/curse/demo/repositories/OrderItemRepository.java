package com.curse.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curse.demo.models.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
}