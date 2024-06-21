package com.example.BackenMotorcycle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackenMotorcycle.entity.Brandcycle;
import com.example.BackenMotorcycle.services.impl.BrandcycleServiceImpl;

@RestController
@RequestMapping(path = "api/v1/brandcycle")
public class BrandcycleController {

    @Autowired
    private BrandcycleServiceImpl brandcycleService;

    @GetMapping("list")
    public List<Brandcycle> findAll() {
        return brandcycleService.findAll();
    }

    @GetMapping("view/{id}")
    public Brandcycle getMotorcycle(@PathVariable Long id) {
        return brandcycleService.findById(id);
    }

    @PostMapping("create")
    public Brandcycle createMotorcycle(@RequestBody Brandcycle motorcycle) {
        return brandcycleService.create(motorcycle);
    }

    @PutMapping("update/{id}")
    public Brandcycle updateMotorcycle(@RequestBody Brandcycle motorcycle, @PathVariable Long id) {
        return brandcycleService.edit(id, motorcycle);
    }

    @DeleteMapping("delete/{id}")
    public void updateMotorcycle(@PathVariable Long id) {
        brandcycleService.delete(id);
    }
}
