package com.example.BackenMotorcycle.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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


//    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private List<MotorcycleType> motorcycleTypes;
    @ManyToOne
    @JoinColumn(name = "motorcycle_type_id")
    @JsonBackReference  // Esta es la parte contralada de la relación
    private MotorcycleType motorcycleType;
}
