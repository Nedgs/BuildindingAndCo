package com.buildindingandco.BuildindingAndCo.mapper;

import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;

import com.buildindingandco.BuildindingAndCo.dtos.VehiculeDto;
import com.buildindingandco.BuildindingAndCo.model.Vehicules;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {
    
    @Mapping(target = "technicien", ignore = true)
     VehiculeDto map(Vehicules vehicule);

    List<VehiculeDto> map(List<Vehicules> vehicules);
}
