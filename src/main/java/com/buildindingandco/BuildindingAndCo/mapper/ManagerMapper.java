package com.buildindingandco.BuildindingAndCo.mapper;

import com.buildindingandco.BuildindingAndCo.dtos.ManagerDto;
import com.buildindingandco.BuildindingAndCo.model.Manager;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;
@Mapper(componentModel = "spring")
public interface ManagerMapper {
    

    ManagerDto map(Manager manager);

    List<ManagerDto> map(List<Manager> manager);

}
