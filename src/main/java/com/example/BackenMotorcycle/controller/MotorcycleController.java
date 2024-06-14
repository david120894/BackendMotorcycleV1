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

import com.example.BackenMotorcycle.entity.Motorcycle;
import com.example.BackenMotorcycle.services.MotorcycleService;

@RestController
@RequestMapping(path = "api/v1/motorcycle")
public class MotorcycleController {
    @Autowired
    private MotorcycleService motorcycleService;

    @GetMapping("list")
    public List<Motorcycle> findAll() {
        return motorcycleService.findAll();
    }

    @GetMapping("view/{id}")
    public Motorcycle getMotorcycle(@PathVariable Long id) {
        return motorcycleService.findById(id);
    }

    @GetMapping("motorcycleType/{id}")
    public List<Motorcycle> getMotorcycleType(@PathVariable Long id) {
        return motorcycleService.findAllByMotorcycle(id);
    }

    @PostMapping("create")
    public Motorcycle createMotorcycle(@RequestBody Motorcycle motorcycle) {
        return motorcycleService.create(motorcycle);
    }

    @PutMapping("update/{id}")
    public Motorcycle updateMotorcycle(@RequestBody Motorcycle motorcycle, @PathVariable Long id) {
        return motorcycleService.edit(id, motorcycle);
    }

    @DeleteMapping("delete/{id}")
    public void updateMotorcycle(@PathVariable Long id) {
        motorcycleService.delete(id);
    }

}
