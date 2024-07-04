package com.example.BackenMotorcycle.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class ProductMotorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private int stock;

    private String image;

    @ManyToOne
    @JoinColumn (name = "product_type_id")
    private ProductMotorcycleType productMotorcycleType;
}
