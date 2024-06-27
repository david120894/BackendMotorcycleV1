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

import com.example.BackenMotorcycle.entity.MotorcycleType;
import com.example.BackenMotorcycle.services.impl.MotorcycleTypeServiceImpl;

@RestController
@RequestMapping(path = "api/v1/motorcycle_type")
public class  MotorcycleTypeController {

    @Autowired
    private MotorcycleTypeServiceImpl motorcycleTypeService;

    @GetMapping("list")
    public List<MotorcycleType> findAll() {
        return motorcycleTypeService.findAll();
    }

    @GetMapping("view/{id}")
    public MotorcycleType getMotorcycle(@PathVariable Long id) {
        return motorcycleTypeService.findById(id);
    }

    @PostMapping("create")
    public MotorcycleType createMotorcycle(@RequestBody MotorcycleType motorcycle) {
        return motorcycleTypeService.create(motorcycle);
    }

    @PutMapping("update/{id}")
    public MotorcycleType updateMotorcycle(@RequestBody MotorcycleType motorcycle, @PathVariable Long id) {
        return motorcycleTypeService.edit(id, motorcycle);
    }

    @DeleteMapping("delete/{id}")
    public void updateMotorcycle(@PathVariable Long id) {
        motorcycleTypeService.delete(id);
    }
}
