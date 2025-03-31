package com.prjgrp.artf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prjgrp.artf.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
