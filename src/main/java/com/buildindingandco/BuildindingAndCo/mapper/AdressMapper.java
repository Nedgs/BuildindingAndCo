package com.buildindingandco.BuildindingAndCo.mapper;

import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;

import com.buildindingandco.BuildindingAndCo.dtos.AdressDto;
import com.buildindingandco.BuildindingAndCo.model.Adress;

@Mapper(componentModel = "spring")
public interface AdressMapper {
    
     AdressDto map(Adress adress);

     List<AdressDto> map(List<Adress> adresses);

}
