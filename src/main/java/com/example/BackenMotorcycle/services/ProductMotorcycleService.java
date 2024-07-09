package com.example.BackenMotorcycle.services;

import com.example.BackenMotorcycle.entity.ProductMotorcycle;
import com.example.BackenMotorcycle.entity.ProductMotorcycleType;

import java.util.List;

public interface ProductMotorcycleService {
    List<ProductMotorcycle> findAll();

    ProductMotorcycle findById(Long id);

    List<ProductMotorcycle> findAllByProductMotorcycle(Long id);

    ProductMotorcycle create(ProductMotorcycle productMotorcycle);

    ProductMotorcycle edit(Long id, ProductMotorcycle productMotorcycle);

    List<ProductMotorcycle> findProductsByType(ProductMotorcycleType type);


    void delete(Long id);
}
