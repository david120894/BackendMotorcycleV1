package com.example.BackenMotorcycle.services;

import java.io.IOException;
import java.util.List;

import com.example.BackenMotorcycle.entity.Motorcycle;

public interface MotorcycleService {
    List<Motorcycle> findAll();

    // List<Motorcycle> findAllNivelRemunerativo(Long id);

    Motorcycle findById(Long id);

    List<Motorcycle> findAllByMotorcycle(Long id);

    Motorcycle create(Motorcycle motorcycle) throws IOException;

    Motorcycle edit(Long id, Motorcycle motorcycle);

    void delete(Long id);

}
