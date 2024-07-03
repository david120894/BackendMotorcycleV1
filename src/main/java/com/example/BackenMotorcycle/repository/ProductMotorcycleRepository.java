package com.example.BackenMotorcycle.repository;

import com.example.BackenMotorcycle.entity.ProductMotorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMotorcycleRepository extends JpaRepository<ProductMotorcycle, Long> {
}
