package com.buildindingandco.BuildindingAndCo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;

import com.buildindingandco.BuildindingAndCo.dtos.TechnicienDto;
import com.buildindingandco.BuildindingAndCo.model.Technicien;

@Mapper(componentModel = "spring")
public interface TechnicienMapper {
    @Mapping(target = "manager", ignore = true)
    TechnicienDto map(Technicien technicien);

   List<TechnicienDto> map(List<Technicien> techniciens);
}
