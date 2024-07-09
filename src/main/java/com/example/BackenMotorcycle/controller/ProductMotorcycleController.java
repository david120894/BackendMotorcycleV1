package com.example.BackenMotorcycle.controller;

import com.example.BackenMotorcycle.entity.ProductMotorcycle;
import com.example.BackenMotorcycle.entity.ProductMotorcycleType;
import com.example.BackenMotorcycle.services.ProductMotorcycleService;
import com.example.BackenMotorcycle.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
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

    @GetMapping("byType/{typeId}")
    public List<ProductMotorcycle> getProductsByType(@PathVariable Long typeId) {
        ProductMotorcycleType type = new ProductMotorcycleType();
        type.setId(typeId);

        return productMotorcycleService.findProductsByType(type);
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
    @GetMapping("image/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws IOException {
        if (filename == null || filename.isEmpty()) {
            throw new RuntimeException("Filename is null");
        }
        Resource file = productService.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(file);
    }
}
