package com.example.BackenMotorcycle.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "motorcycle_type")
public class MotorcycleType {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String motorcycleType;

    @ManyToOne
    @JoinColumn(name = "motorCycle")
    private Motorcycle motorcycle;




}
