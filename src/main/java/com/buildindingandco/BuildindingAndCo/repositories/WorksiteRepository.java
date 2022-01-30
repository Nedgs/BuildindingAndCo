package com.buildindingandco.BuildindingAndCo.repositories;

import com.buildindingandco.BuildindingAndCo.model.Worksite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorksiteRepository extends JpaRepository<Worksite,Long> {
    
}
