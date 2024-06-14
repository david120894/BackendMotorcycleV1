package com.example.BackenMotorcycle.services;

import java.util.List;

import com.example.BackenMotorcycle.entity.MotorcycleType;

public interface MotorcycleTypeService {
    List<MotorcycleType> findAll();

    MotorcycleType findById(Long id);

    MotorcycleType create(MotorcycleType motorcycleType);

    MotorcycleType edit(Long id, MotorcycleType motorcycleType);

    void delete(Long id);
}
