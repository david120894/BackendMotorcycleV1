package com.example.BackenMotorcycle.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "motorcycle_type")
public class MotorcycleType {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String motorcycleType;

//    @ManyToOne
//    @JoinColumn(name = "motorCycle")
//    @JsonBackReference
//    private Motorcycle motorcycle;
    @OneToMany(mappedBy = "motorcycleType", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  // Esta es la parte administrada de la relación
    private List<Motorcycle> motorcycle;
}
