package com.example.BackenMotorcycle.services;

import com.example.BackenMotorcycle.entity.MotorcycleType;
import com.example.BackenMotorcycle.repository.MotorcycleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleTypeService {
    @Autowired
    MotorcycleTypeRepository motorcycleTypeRepository;

    public List<MotorcycleType> getAll(){
        return motorcycleTypeRepository.findAll();
    }

    public MotorcycleType createMotorcycleType(MotorcycleType motorcycleType){
        return motorcycleTypeRepository.save(motorcycleType);
    }

    public MotorcycleType updateMotorcycleType(MotorcycleType motorcycleType){
        return motorcycleTypeRepository.save(motorcycleType);

    }

    public void deleteMotorcycleType(Long id){
        motorcycleTypeRepository.deleteById(id);
    }
}
