package com.example.BackenMotorcycle.services;

import java.util.List;

import com.example.BackenMotorcycle.entity.Brandcycle;

public interface BrandcycleService {
    List<Brandcycle> findAll();

    Brandcycle findById(Long id);

    Brandcycle create(Brandcycle brandcycle);

    Brandcycle edit(Long id, Brandcycle brandcycle);

    void delete(Long id);
}
