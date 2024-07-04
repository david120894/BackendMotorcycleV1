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

    private String model;

    private int year;

    private String color;

    private String price;

    private String image;

    @ManyToOne
    @JoinColumn(name = "brandcycle_id")
    private Brandcycle brandcycle;

    @ManyToOne
    @JoinColumn(name = "motorcycle_type_id")
    private MotorcycleType motorcycleType;
}
