package com.tn.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;

    private String pice;
}
