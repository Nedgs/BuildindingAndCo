package com.buildindingandco.BuildindingAndCo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;


import com.buildindingandco.BuildindingAndCo.model.Adress;

public interface AdressRepository extends JpaRepository<Adress, Long>{
    
}
