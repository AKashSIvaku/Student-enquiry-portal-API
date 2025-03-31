package com.prjgrp.artf.controller;

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

import com.prjgrp.artf.model.Faq;
import com.prjgrp.artf.model.User;
import com.prjgrp.artf.service.FaqService;

@RestController
@RequestMapping("/")
public class FaqController {
  @Autowired
  FaqService service;

  @GetMapping("/faqs")
  public ResponseEntity<List<Faq>> getAllUsers() { 
    List<Faq> user = service.getAllfaqs(); 
    return ResponseEntity.status(HttpStatus.OK).body(user);
 }
   @GetMapping("/faqs/{id}")
   public ResponseEntity<Faq> getUserById(@PathVariable int id) {
    Faq user = service.getFaqById(id);
    if (user == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    return ResponseEntity.ok(user);
}

 @PostMapping("/faqs")
    public Faq createUser(@RequestBody Faq u){
        return service.createfaqs(u);
    }

     @PutMapping("/faqs/{id}")
    public ResponseEntity<Faq> updateFaq(@PathVariable int id, @RequestBody Faq faq) {
        if (service.getFaqById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Faq updatedFaq = service.updatefaqs(id, faq);
        return ResponseEntity.ok(updatedFaq);
    }

    
    @DeleteMapping("/faqs/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        return service.deletefaqs(id)?ResponseEntity.status(HttpStatus.NO_CONTENT).body("delete successfully"):ResponseEntity.status(HttpStatus.NOT_FOUND).body("delete failed");
    }
}
