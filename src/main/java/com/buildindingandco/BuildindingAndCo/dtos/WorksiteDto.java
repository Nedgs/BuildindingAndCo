package com.buildindingandco.BuildindingAndCo.dtos;

import java.util.List;

import com.buildindingandco.BuildindingAndCo.model.Adress;
import com.buildindingandco.BuildindingAndCo.model.Technicien;

import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(value = "worksite")
public class WorksiteDto {

    @ApiModelProperty(notes = "id du chantier", name = "id", value = "1")
    Long id; 
    
    @ApiModelProperty(notes = "nom du chantier", name = "name", value = "abcd")
    String name;


    @ApiModelProperty(notes = "prix du chantier", name = "price", value = "abcd")
    Float price;

    @Nullable
    @ApiModelProperty(notes = "adresse du chantier", name = "adresse", hidden = true)
    AdressDto adress;

    @Nullable
    @ApiModelProperty(notes = "liste des techniciens du chantier", name = "1", hidden = true)
    List<TechnicienDto> techniciens;

    public WorksiteDto(Long id,
    String name,
    Float price,
    Adress adress,
    List<Technicien> technicien){
        this.id=id;
        this.name=name;
        this.price=price;
    }
}
