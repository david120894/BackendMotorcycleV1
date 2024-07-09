package com.example.BackenMotorcycle.repository;

import com.example.BackenMotorcycle.entity.ProductMotorcycle;
import com.example.BackenMotorcycle.entity.ProductMotorcycleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMotorcycleRepository extends JpaRepository<ProductMotorcycle, Long> {
    List<ProductMotorcycle> findByProductMotorcycleType(ProductMotorcycleType productMotorcycleType);
}
