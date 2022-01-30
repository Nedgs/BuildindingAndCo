package com.buildindingandco.BuildindingAndCo.repositories;

import com.buildindingandco.BuildindingAndCo.model.Vehicules;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicules,Long> {
    
}
