package com.curse.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.curse.demo.models.User;
import com.curse.demo.repositories.UserRepository;
import com.curse.demo.services.exceptions.DatabaseException;
import com.curse.demo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(()->new ResourceNotFoundException(id));
    }
    public User insert(User obj){
        return userRepository.save(obj);
    }

    public void delete(Long id){
        
        try{
            userRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
        
    }
    public User update(Long id, User obj){
        try{
        User entity = userRepository.getReferenceById(id);
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setFone(obj.getFone());

        return userRepository.save(entity);
        }catch(EntityNotFoundException e){
            throw  new ResourceNotFoundException(id);
        }
        
    }
}
