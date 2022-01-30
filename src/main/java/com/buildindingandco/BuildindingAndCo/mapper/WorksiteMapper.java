package com.buildindingandco.BuildindingAndCo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;
import com.buildindingandco.BuildindingAndCo.dtos.WorksiteDto;
import com.buildindingandco.BuildindingAndCo.model.Worksite;

import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface WorksiteMapper {


    @Mapping(target = "adress", ignore = true)
     WorksiteDto map(Worksite worksite);

    List<WorksiteDto> map(List<Worksite> adresses);
}
