package com.example.BackenMotorcycle.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "brandcycle")
public class Brandcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brandcycle;

}
