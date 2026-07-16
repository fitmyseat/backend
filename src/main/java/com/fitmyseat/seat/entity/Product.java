package com.fitmyseat.seat.entity;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleName;

    private String model;

    private String color;

    private String stitch;

    private BigDecimal price;

    private String imageUrl;

    private String cloudinaryPublicId;

    private LocalDateTime createdAt;
    
    private Integer quantity;

    // getters/setters
}