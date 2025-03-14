package com.curse.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curse.demo.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    

}
