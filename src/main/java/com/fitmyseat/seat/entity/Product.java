package com.fitmyseat.seat.entity;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("vehicle_name")
    private String vehicleName;

    private String model;

    private String color;

    private String stitch;

    private BigDecimal price;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("cloudinary_public_id")
    private String cloudinaryPublicId;

    private LocalDateTime createdAt;
    
    private Integer quantity;

    // getters/setters
}