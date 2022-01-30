package com.buildindingandco.BuildindingAndCo.dtos;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(value = "technicien")
public class TechnicienDto {
    @ApiModelProperty(notes = "id du technincien", name = "id", value = "1")
    Long id; 

    @ApiModelProperty(notes = "nom du technicien", name = "name", value = "Xavier")
    String name;

    @ApiModelProperty(notes = "prénom du technicien", name = "firstname", value = "Bertrand")
    String firstname;

    @ApiModelProperty(notes = "prénom du technicien", name = "firstname", value = "28")
    int age;

    @ApiModelProperty(notes = "adresse du technicien", name = "adress", hidden = true)
    AdressDto adress;

    @ApiModelProperty(notes = "manager du technicien", name = "manager", hidden = true)
    ManagerDto manager;

    @ApiModelProperty(notes = "chantiers du technicien", name = "chantier", hidden = true)
    List<WorksiteDto> worksites;

    
    public TechnicienDto(Long id,
    String name,
    String firstname,
    int age,
    AdressDto adress,
    ManagerDto manager,
    List<WorksiteDto> worksites){
        this.id=id;
        this.name=name;
        this.firstname=firstname;
        this.adress=adress;
        this.worksites=worksites;
    }
}
