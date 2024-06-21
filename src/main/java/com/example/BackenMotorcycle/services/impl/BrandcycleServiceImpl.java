package com.example.BackenMotorcycle.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackenMotorcycle.entity.Brandcycle;
import com.example.BackenMotorcycle.repository.BrandcycleRepository;
import com.example.BackenMotorcycle.services.BrandcycleService;

import jakarta.transaction.Transactional;

@Service
public class BrandcycleServiceImpl implements BrandcycleService {
    @Autowired
    private BrandcycleRepository brandcycleRepository;

    @Override
    public List<Brandcycle> findAll() {
        return brandcycleRepository.findAll();
    }

    @Override
    public Brandcycle findById(Long id) {
        return brandcycleRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Brandcycle create(Brandcycle brandcycle) {
        return brandcycleRepository.save(brandcycle);
    }

    @Override
    @Transactional
    public Brandcycle edit(Long id, Brandcycle brandcycle) {
        Brandcycle aux = findById(id);
        aux.setBrandcycle(brandcycle.getBrandcycle());

        return brandcycleRepository.save(aux);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        brandcycleRepository.deleteById(id);
    }
}
