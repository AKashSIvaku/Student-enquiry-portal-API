package com.prjgrp.artf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faq {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
    private String username;
    private String email;
}
