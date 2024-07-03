package com.example.BackenMotorcycle.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productType")
public class ProductMotorcycleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;
}
