package com.example.BackenMotorcycle.services;

import com.example.BackenMotorcycle.entity.ProductMotorcycleType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductMotorcycleTypeService {
    List<ProductMotorcycleType> findAll();
    ProductMotorcycleType findById(Long id);
    ProductMotorcycleType create(ProductMotorcycleType productMotorcycleType);
    ProductMotorcycleType edit(Long id, ProductMotorcycleType productMotorcycleType);
    void delete(Long id);
}
