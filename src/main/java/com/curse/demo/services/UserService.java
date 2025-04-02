package com.curse.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curse.demo.models.User;
import com.curse.demo.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Long id){
        return userRepository.findById(id).get();
    }
    public User insert(User obj){
        return userRepository.save(obj);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
    public User update(Long id, User obj){

        User entity = userRepository.getReferenceById(id);
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setFone(obj.getFone());
        
        return userRepository.save(entity);
    }
}
