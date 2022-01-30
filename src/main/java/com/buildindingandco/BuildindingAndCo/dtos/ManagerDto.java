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
@ApiModel(value = "manager")
public class ManagerDto {

    @ApiModelProperty(notes = "id du manager", name = "id", value = "1")
    Long id; 

    @ApiModelProperty(notes = "nom du manager", name = "name", value = "Xavier")
    String name;

    @ApiModelProperty(notes = "prénom du manager", name = "firstname", value = "Bertrand")
    String firstname;

    @ApiModelProperty(notes = "numéro de fixe du manager", name = "fixNumber", value = "0606060606")
    String fixNumber;

    @ApiModelProperty(notes = "numéro de mobile du manager", name = "mobileNumber", value = "0606060606")
    String mobileNumber;

    @ApiModelProperty(notes = "Techniciens aux aurdres du manager", name = "techniciens", hidden = true)
    List<TechnicienDto> techniciens;

    public ManagerDto(Long id,
    String name,
    String firstname,
    String mobileNumber,
    String fixNumber,
    List<TechnicienDto> techniciens){
        this.id=id;
        this.name=name;
        this.firstname=firstname;
        this.fixNumber=fixNumber;
        this.mobileNumber=mobileNumber;
        this.techniciens=techniciens;
    }
}
