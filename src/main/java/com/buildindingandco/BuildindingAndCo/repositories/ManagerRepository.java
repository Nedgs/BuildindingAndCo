package com.buildindingandco.BuildindingAndCo.repositories;

import com.buildindingandco.BuildindingAndCo.model.Manager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    
}
