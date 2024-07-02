package com.example.BackenMotorcycle.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.example.BackenMotorcycle.services.BrandcycleService;
import com.example.BackenMotorcycle.services.MotorcycleTypeService;
import com.example.BackenMotorcycle.services.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BackenMotorcycle.entity.Motorcycle;
import com.example.BackenMotorcycle.services.MotorcycleService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "api/v1/motorcycle")
public class MotorcycleController {
    private static final Logger log = LoggerFactory.getLogger(MotorcycleController.class);
    @Autowired
    private MotorcycleService motorcycleService;

    @Autowired
    private BrandcycleService brandcycleService;

    @Autowired
    private MotorcycleTypeService motorcycleTypeService;

    @Autowired
    private StorageService storageService;

    @GetMapping("list")
    public List<Motorcycle> findAll() {
        return motorcycleService.findAll();
    }

    @GetMapping("view/{id}")
    public Motorcycle getMotorcycle(@PathVariable Long id) {

//        return motorcycleService.findById(id);
        Motorcycle motorcycle = motorcycleService.findById(id);
        if (motorcycle != null && motorcycle.getImage() != null) {
            String imageUrl = buildImageUrl(motorcycle.getImage());
            motorcycle.setImage(imageUrl);
        }
        return motorcycle;
    }

    @GetMapping("motorcycleType/{id}")
    public List<Motorcycle> getMotorcycleType(@PathVariable Long id) {
        return motorcycleService.findAllByMotorcycle(id);
    }

    @PostMapping("create")
    public Motorcycle createMotorcycle(
            @RequestParam("motorcycle") Motorcycle motorcycle, @RequestParam("file") MultipartFile file) throws IOException {

        String filePath = storageService.store(file);
        motorcycle.setImage(filePath);

        return motorcycleService.create(motorcycle);

    }

    @PutMapping("update/{id}")
    public Motorcycle updateMotorcycle(
            @RequestBody Motorcycle motorcycle, @PathVariable Long id) {
        return motorcycleService.edit(id, motorcycle);
    }

    @DeleteMapping("delete/{id}")
    public void updateMotorcycle(@PathVariable Long id) {
        motorcycleService.delete(id);
    }

//    @PostMapping("upload")
//    public Motorcycle handleFileUpload(
//            @RequestParam("file") MultipartFile file,
//            @RequestParam("model") String model,
//            @RequestParam("year") int year,
//            @RequestParam("color") String color,
//            @RequestParam("price") String price,
//            @RequestParam("brandcycleId") Long brandcycleId,
//            @RequestParam("motorcycleTypeId") Long motorcycleTypeId) throws IOException {
//
//        String filePath = storageService.store(file);
//
//        Motorcycle motorcycle = new Motorcycle();
//        motorcycle.setModel(model);
//        motorcycle.setYear(year);

//        motorcycle.setColor(color);
//        motorcycle.setPrice(price);
//        motorcycle.setImage(filePath);
//        motorcycle.setBrandcycle(brandcycleService.findById(brandcycleId));
//        motorcycle.setMotorcycleType(motorcycleTypeService.findById(motorcycleTypeId));
//
//        return motorcycleService.create(motorcycle);
//    }

    @GetMapping("image/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws IOException {
        if (filename == null || filename.isEmpty()) {
            throw new RuntimeException("Filename is null");
        }
        Resource file = storageService.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(file);
    }


    private String buildImageUrl(String filename) {
        // Ajusta esta URL base según sea necesario para que coincida con tu configuración
        return "http://localhost:8080/api/v1/motorcycle/image/" + filename;
    }
}
