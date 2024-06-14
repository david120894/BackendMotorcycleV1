package com.example.BackenMotorcycle.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "motorcycle")
public class Motorcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private int year;
    private String color;
    private String price;

    @ManyToOne
    @JoinColumn(name = "motorcycle_type_id")
    private MotorcycleType motorcycleType;
}
