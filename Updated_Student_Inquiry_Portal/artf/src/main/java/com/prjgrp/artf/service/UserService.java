package com.prjgrp.artf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prjgrp.artf.model.User;
import com.prjgrp.artf.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository repo;

    public List<User> getAllUsers(){
        return repo.findAll();
    }
    public User getUserById(int id){
        return repo.findById(id).orElse(null);
    }

    public boolean createUser(User u) {
    if (!repo.existsById(u.getId())) {
        repo.save(u);
        return true;
    }
    return false;
}


    public User updateUser(int id,User u) {
        u.setId(id);
        return repo.save(u);
    }

    public boolean deleteUser(int id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
    public Page<User> getUserPaginate(Pageable pageable) {
        return repo.findAll(pageable);
    }

}
