package com.example.BackenMotorcycle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BackenMotorcycle.entity.Brandcycle;

@Repository
public interface BrandcycleRepository extends JpaRepository<Brandcycle, Long> {

}
