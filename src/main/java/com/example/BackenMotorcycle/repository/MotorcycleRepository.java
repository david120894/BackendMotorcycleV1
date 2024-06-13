package com.example.BackenMotorcycle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackenMotorcycle.entity.Motorcycle;
import com.example.BackenMotorcycle.entity.MotorcycleType;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {

    List<Motorcycle> findAllByMotorcycleType(MotorcycleType motorcycleType);
}
