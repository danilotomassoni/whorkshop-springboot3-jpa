package com.curse.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curse.demo.models.User;
import com.curse.demo.services.UserService;




@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        User obj = userService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }
    @PostMapping    
    public ResponseEntity<User> insert(@RequestBody User user) {
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj) {
        obj = userService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
