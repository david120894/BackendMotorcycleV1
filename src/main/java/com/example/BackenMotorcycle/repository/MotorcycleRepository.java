package com.example.BackenMotorcycle.repository;

import com.example.BackenMotorcycle.entity.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorcycleRepository extends JpaRepository<Motorcycle,Long> {
}
