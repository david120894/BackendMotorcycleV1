package com.example.BackenMotorcycle.controller;

import com.example.BackenMotorcycle.entity.ProductMotorcycle;
import com.example.BackenMotorcycle.entity.ProductMotorcycleType;
import com.example.BackenMotorcycle.services.ProductMotorcycleService;
import com.example.BackenMotorcycle.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductMotorcycleController {

    @Autowired
    private ProductMotorcycleService productMotorcycleService;
    @Autowired
    private ProductService productService;
    @GetMapping("list")
    public List<ProductMotorcycle> findAll() {
        return productMotorcycleService.findAll();
    }

    @GetMapping("view/{id}")
    public ProductMotorcycle getProductMotorcycle(@PathVariable Long id) {
        return productMotorcycleService.findById(id);
    }

    @PostMapping("create")
    public ProductMotorcycle createProductMotorcycle(@RequestPart("product") String productJson,
                                                     @RequestPart("file") MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
            ProductMotorcycle productMotorcycle= objectMapper.readValue(productJson, ProductMotorcycle.class);
            String filePath = productService.product(file);
            productMotorcycle.setImage(filePath);
        return productMotorcycleService.create(productMotorcycle);
    }
    @PutMapping("update/{id}")
    public ProductMotorcycle update(@PathVariable Long id, @RequestBody ProductMotorcycle productMotorcycle) {
        return productMotorcycleService.edit(id, productMotorcycle);
    }
}
