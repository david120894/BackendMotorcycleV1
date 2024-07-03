package com.example.BackenMotorcycle.repository;

import com.example.BackenMotorcycle.entity.ProductMotorcycleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMotorcycleTypeRepository extends JpaRepository<ProductMotorcycleType, Long> {
}
