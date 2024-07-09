package com.example.BackenMotorcycle.services.impl;

import com.example.BackenMotorcycle.entity.ProductMotorcycle;
import com.example.BackenMotorcycle.entity.ProductMotorcycleType;
import com.example.BackenMotorcycle.repository.ProductMotorcycleRepository;
import com.example.BackenMotorcycle.services.ProductMotorcycleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMotorcycleServiceImpl implements ProductMotorcycleService {
    @Autowired
    private ProductMotorcycleRepository productMotorcycleRepository;

    @Override
    public List<ProductMotorcycle> findAll() {
        return productMotorcycleRepository.findAll();
    }

    @Override
    public ProductMotorcycle findById(Long id) {
        return productMotorcycleRepository.findById(id).get();
    }

    @Override
    public List<ProductMotorcycle> findAllByProductMotorcycle(Long id) {
        return List.of();
    }

    @Override
    public ProductMotorcycle create(ProductMotorcycle productMotorcycle) {
        return productMotorcycleRepository.save(productMotorcycle);
    }

    @Override
    public ProductMotorcycle edit(Long id, ProductMotorcycle productMotorcycle) {
        ProductMotorcycle auxProduct = findById(id);
        auxProduct.setName(productMotorcycle.getName());
        auxProduct.setDescription(productMotorcycle.getDescription());
        auxProduct.setPrice(productMotorcycle.getPrice());
        auxProduct.setStock(productMotorcycle.getStock());
        return productMotorcycleRepository.save(productMotorcycle);
    }

    @Override
    public List<ProductMotorcycle> findProductsByType(ProductMotorcycleType type) {
        return productMotorcycleRepository.findByProductMotorcycleType(type);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productMotorcycleRepository.deleteById(id);
    }
}
