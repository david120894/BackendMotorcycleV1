package com.example.BackenMotorcycle.services;

import com.example.BackenMotorcycle.entity.ProductMotorcycle;

import java.util.List;

public interface ProductMotorcycleService {
    List<ProductMotorcycle> findAll();

    ProductMotorcycle findById(Long id);

    List<ProductMotorcycle> findAllByProductMotorcycle(Long id);

    ProductMotorcycle create(ProductMotorcycle productMotorcycle);

    ProductMotorcycle edit(Long id, ProductMotorcycle productMotorcycle);

    void delete(Long id);
}
