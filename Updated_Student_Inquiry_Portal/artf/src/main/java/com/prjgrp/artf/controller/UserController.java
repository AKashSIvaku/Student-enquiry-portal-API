package com.prjgrp.artf.controller;

import java.net.URI;
import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prjgrp.artf.model.User;
import com.prjgrp.artf.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService service;

   @GetMapping("/user")
   public ResponseEntity<List<User>> getAllUsers() { 
    List<User> user = service.getAllUsers(); 
    return ResponseEntity.status(HttpStatus.OK).body(user);
 }
@GetMapping("/user/{id}")
public ResponseEntity<User> getUserById(@PathVariable int id) {
    User user = service.getUserById(id);
    if (user == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    return ResponseEntity.ok(user);
}

    
    @PostMapping("/user")
   public ResponseEntity<String> createUser(@RequestBody User u){ 
     if (service.createUser(u)) { 
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created"); 
    } else {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user"); 
        }
    
}
    @PutMapping("/user/{id}")
public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User u) {
    if (service.getUserById(id) == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    User updatedUser = service.updateUser(id, u);
    return ResponseEntity.ok(updatedUser);
}

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        return service.deleteUser(id)?ResponseEntity.status(HttpStatus.NO_CONTENT).body("delete successfully"):ResponseEntity.status(HttpStatus.NOT_FOUND).body("delete failed");
    }

    @GetMapping("/user/paginate")
    public ResponseEntity<Page<User>> getUserPaginate(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "true") boolean sortOrder
    ){
        Sort sort = sortOrder ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page,size, sort);
        return new ResponseEntity<>(service.getUserPaginate(pageable), HttpStatus.OK);

    }
    
}
