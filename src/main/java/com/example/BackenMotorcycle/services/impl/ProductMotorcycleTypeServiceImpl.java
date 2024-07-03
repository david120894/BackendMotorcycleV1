package com.example.BackenMotorcycle.services.impl;

import com.example.BackenMotorcycle.entity.ProductMotorcycleType;
import com.example.BackenMotorcycle.repository.ProductMotorcycleTypeRepository;
import com.example.BackenMotorcycle.services.ProductMotorcycleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMotorcycleTypeServiceImpl implements ProductMotorcycleTypeService {
    @Autowired
    private ProductMotorcycleTypeRepository productMotorcycleTypeRepository;
    @Override
    public List<ProductMotorcycleType> findAll() {
        return productMotorcycleTypeRepository.findAll();
    }

    @Override
    public ProductMotorcycleType findById(Long id) {
        return productMotorcycleTypeRepository.findById(id).get();
    }

    @Override
    public ProductMotorcycleType create(ProductMotorcycleType productMotorcycleType) {
        return productMotorcycleTypeRepository.save(productMotorcycleType);
    }

    @Override
    public ProductMotorcycleType edit(Long id, ProductMotorcycleType productMotorcycleType) {
        ProductMotorcycleType auxProductMotorcycleType = findById(id);
        auxProductMotorcycleType.setId(productMotorcycleType.getId());
        auxProductMotorcycleType.setTypeName(productMotorcycleType.getTypeName());
        return productMotorcycleTypeRepository.save(auxProductMotorcycleType);
    }

    @Override
    public void delete(Long id) {
        productMotorcycleTypeRepository.deleteById(id);
    }
}
