package com.example.BackenMotorcycle.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackenMotorcycle.entity.MotorcycleType;
import com.example.BackenMotorcycle.repository.MotorcycleTypeRepository;
import com.example.BackenMotorcycle.services.MotorcycleTypeService;

import jakarta.transaction.Transactional;

@Service
public class MotorcycleTypeServiceImpl implements MotorcycleTypeService {
    @Autowired
    private MotorcycleTypeRepository motorcycleTypeRepository;

    @Override
    public List<MotorcycleType> findAll() {
        return motorcycleTypeRepository.findAll();
    }

    @Override
    public MotorcycleType findById(Long id) {
        return motorcycleTypeRepository.findById(id).get();
    }

    @Override
    @Transactional
    public MotorcycleType create(MotorcycleType motorcycleType) {
        return motorcycleTypeRepository.save(motorcycleType);
    }

    @Override
    @Transactional
    public MotorcycleType edit(Long id, MotorcycleType motorcycleType) {
        MotorcycleType aux = findById(id);
        aux.setMotorcycleType(motorcycleType.getMotorcycleType());

        return motorcycleTypeRepository.save(aux);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        motorcycleTypeRepository.deleteById(id);
    }
}
