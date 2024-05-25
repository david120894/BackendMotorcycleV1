package com.example.BackenMotorcycle.repository;

import com.example.BackenMotorcycle.entity.MotorcycleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcycleTypeRepository extends JpaRepository<MotorcycleType, Long> {
}
