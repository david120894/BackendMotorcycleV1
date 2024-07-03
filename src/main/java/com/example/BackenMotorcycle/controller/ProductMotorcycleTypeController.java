package com.example.BackenMotorcycle.controller;

import com.example.BackenMotorcycle.entity.ProductMotorcycleType;
import com.example.BackenMotorcycle.services.ProductMotorcycleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product_type")
public class ProductMotorcycleTypeController {
    @Autowired
    private ProductMotorcycleTypeService productMotorcycleTypeService;

    @GetMapping("list")
    public List<ProductMotorcycleType> findAll() {
        return productMotorcycleTypeService.findAll();
    }

    @GetMapping("view/{id}")
    public ProductMotorcycleType findById(@PathVariable Long id) {
        return productMotorcycleTypeService.findById(id);
    }

    @PostMapping("create")
    public ProductMotorcycleType createProductMotorcycleType(@RequestBody ProductMotorcycleType productMotorcycleType) {
        return productMotorcycleTypeService.create(productMotorcycleType);
    }

    @PutMapping("update/{id}")
    public ProductMotorcycleType updateProductMotorcycleType(@RequestBody ProductMotorcycleType productMotorcycleType, @PathVariable Long id) {
        return productMotorcycleTypeService.edit(id, productMotorcycleType);
    }
}
