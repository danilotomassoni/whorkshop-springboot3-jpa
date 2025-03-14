package com.curse.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curse.demo.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    



}
