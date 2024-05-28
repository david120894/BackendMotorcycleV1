package com.example.BackenMotorcycle.controller;

import com.example.BackenMotorcycle.entity.MotorcycleType;
import com.example.BackenMotorcycle.services.MotorcycleService;
import com.example.BackenMotorcycle.services.MotorcycleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/motorcycle_type")
public class MotorcycleTypeController {

    @Autowired
    private MotorcycleTypeService motorcycleTypeService;

    @GetMapping
    public List<MotorcycleType> getMotorcycleType() {
        return motorcycleTypeService.getAll();
    }

    @PostMapping
    public MotorcycleType createMotorcycleType(@RequestBody MotorcycleType motorcycleType) {
        return motorcycleTypeService.createMotorcycleType(motorcycleType);
    }

    @PostMapping("update/{id}")
    public MotorcycleType updateMotorcycle(@RequestBody MotorcycleType motorcycleType, @PathVariable Long id){
        motorcycleType.setId(id);
        return motorcycleTypeService.updateMotorcycleType(motorcycleType);
    }
}
