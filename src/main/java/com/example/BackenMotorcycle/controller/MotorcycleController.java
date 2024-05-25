package com.example.BackenMotorcycle.controller;

import com.example.BackenMotorcycle.entity.Motorcycle;
import com.example.BackenMotorcycle.services.MotorcycleService;
import com.example.BackenMotorcycle.services.MotorcycleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/motorcycle")
public class MotorcycleController {
    @Autowired
    private MotorcycleService motorcycleService;

    @GetMapping
    public List<Motorcycle> getMotorcycle(){
        return motorcycleService.getAll();
    }

    @PostMapping
    public Motorcycle createMotorcycle(@RequestBody Motorcycle motorcycle){
        return motorcycleService.createMotorcycle(motorcycle);
    }

    @PostMapping("update/{id}")
    public Motorcycle updateMotorcycle(@RequestBody Motorcycle motorcycle, @PathVariable Long id){
        motorcycle.setId(id);
        return motorcycleService.updateMotorcycle(motorcycle);
    }
}
