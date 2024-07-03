package com.example.BackenMotorcycle.controller;

import com.example.BackenMotorcycle.entity.ProductMotorcycle;
import com.example.BackenMotorcycle.entity.ProductMotorcycleType;
import com.example.BackenMotorcycle.services.ProductMotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductMotorcycleController {

    @Autowired
    private ProductMotorcycleService productMotorcycleService;
    @GetMapping("list")
    public List<ProductMotorcycle> findAll() {
        return productMotorcycleService.findAll();
    }

    @GetMapping("view/{id}")
    public ProductMotorcycle getProductMotorcycle(@PathVariable Long id) {
        return productMotorcycleService.findById(id);
    }

    @PostMapping("create")
    public ProductMotorcycle createProductMotorcycle(@RequestBody ProductMotorcycle productMotorcycle) {
        return productMotorcycleService.create(productMotorcycle);
    }
    @PutMapping("update/{id}")
    public ProductMotorcycle update(@PathVariable Long id, @RequestBody ProductMotorcycle productMotorcycle) {
        return productMotorcycleService.edit(id, productMotorcycle);
    }
}
