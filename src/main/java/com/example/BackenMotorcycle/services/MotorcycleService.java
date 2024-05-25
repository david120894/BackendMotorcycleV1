package com.example.BackenMotorcycle.services;

import com.example.BackenMotorcycle.entity.Motorcycle;
import com.example.BackenMotorcycle.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MotorcycleService {

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    public List<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }

    public Motorcycle createMotorcycle(@RequestBody Motorcycle motorcycle){
        return motorcycleRepository.save(motorcycle);
    }

    public Motorcycle updateMotorcycle(@RequestBody Motorcycle motorcycle){
        return motorcycleRepository.save(motorcycle);
    }

    public void deleteMotorcycle(Long id){
        motorcycleRepository.deleteById(id);
    }
}
