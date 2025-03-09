package com.curse.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curse.demo.models.User;

public interface  UserRepository extends JpaRepository<User, Long>{
    
}
