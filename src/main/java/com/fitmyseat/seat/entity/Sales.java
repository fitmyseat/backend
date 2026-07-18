package com.fitmyseat.seat.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
@Data
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("sale_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "sale_date", nullable = false, updatable = false)
    private LocalDate saleDate;

    @JsonProperty("party_name")
    @Column(name = "party_name", nullable = false, length = 200)
    private String partyName;

    @JsonProperty("vehicle_name")
    @Column(name = "vehicle_name", nullable = false, length = 100)
    private String vehicleName;

    @Column(name = "model", length = 100)
    private String model;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "stitch", length = 50)
    private String stitch;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @JsonProperty("unit_price")
    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @JsonProperty("total_price")
    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @JsonProperty("payment_mode")
    @Column(name = "payment_mode", length = 50)
    private String paymentMode;

    @JsonProperty("mobile_number")
    @Column(name = "mobile_number", length = 20)
    private String mobileNumber;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @JsonProperty("product_id")
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (saleDate == null) {
            saleDate = LocalDate.now();
        }
    }
}
