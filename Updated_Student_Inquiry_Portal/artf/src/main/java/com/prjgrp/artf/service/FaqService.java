package com.prjgrp.artf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prjgrp.artf.model.Faq;

import com.prjgrp.artf.repository.FaqRespository;

@Service
public class FaqService {
    @Autowired
    FaqRespository repo;

    public List<Faq> getAllfaqs(){
        return repo.findAll();
    }
    public Faq getFaqById(int id){
        return repo.findById(id).orElse(null);
    }

    public Faq createfaqs(Faq u) {
        return repo.save(u);
    }

    public Faq updatefaqs(int id,Faq u) {
        u.setId(id);
        return repo.save(u);
    }

    public boolean deletefaqs(int id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
