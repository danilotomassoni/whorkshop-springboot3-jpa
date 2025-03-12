package com.curse.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curse.demo.models.Order;

public interface  OrderRepository extends JpaRepository<Order, Long>{

}
