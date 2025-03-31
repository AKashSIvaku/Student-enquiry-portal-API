package com.prjgrp.artf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prjgrp.artf.model.Faq;
@Repository
public interface FaqRespository extends JpaRepository<Faq,Integer>{

}
