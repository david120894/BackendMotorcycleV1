package com.example.BackenMotorcycle.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackenMotorcycle.entity.Motorcycle;
import com.example.BackenMotorcycle.entity.MotorcycleType;
import com.example.BackenMotorcycle.repository.MotorcycleRepository;
import com.example.BackenMotorcycle.services.MotorcycleService;
import com.example.BackenMotorcycle.services.MotorcycleTypeService;

import jakarta.transaction.Transactional;

@Service
public class MotorcycleServiceImpl implements MotorcycleService {

    @Autowired
    private MotorcycleRepository motorcycleRepository;
    @Autowired
    private MotorcycleTypeService motorcycleTypeService;

    @Override
    public List<Motorcycle> findAll() {
        return motorcycleRepository.findAll();
    }

    @Override
    public List<Motorcycle> findAllByMotorcycle(Long id) {
        MotorcycleType aux = motorcycleTypeService.findById(id);
        return motorcycleRepository.findAllByMotorcycleType(aux);
    }

    @Override
    public Motorcycle findById(Long id) {
        return motorcycleRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Motorcycle create(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    @Override
    @Transactional
    public Motorcycle edit(Long id, Motorcycle motorcycle) {
        Motorcycle aux = findById(id);
        aux.setBrandcycle(motorcycle.getBrandcycle());
        aux.setColor(motorcycle.getColor());
        aux.setModel(motorcycle.getModel());
        aux.setPrice(motorcycle.getPrice());
        aux.setYear(motorcycle.getYear());
        aux.setMotorcycleType(motorcycle.getMotorcycleType());
        return motorcycleRepository.save(aux);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        motorcycleRepository.deleteById(id);
    }
}
