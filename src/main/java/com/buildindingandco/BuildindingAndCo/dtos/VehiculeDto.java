package com.buildindingandco.BuildindingAndCo.dtos;
import java.time.LocalDate;
import java.util.List;

import com.buildindingandco.BuildindingAndCo.model.Technicien;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(value = "vehicule")
public class VehiculeDto {

    @ApiModelProperty(notes = "id du technincien", name = "id", value = "1")
    Long id; 

    @ApiModelProperty(notes = "numéro de plaque du véhicule", name = "numPlaque", value = "CA1525BX")
    String numPlaque;

    @ApiModelProperty(notes = "marque du véhicule", name = "brand", value = "BMW")
    String brand;

    @ApiModelProperty(notes = "année de construction du véhicule", name = "builtIn", value = "2012")
    int builtIn;

    @ApiModelProperty(notes = "technicien propriétaire du véhicule", name = "technicien", hidden = true)
    Technicien technicien;

    public VehiculeDto(Long id,
    String numPlaque,
    String brand,
    int builtIn,
    Technicien technicien){
        this.id=id;
        this.numPlaque=numPlaque;
        this.brand=brand;
        this.builtIn=builtIn;
        this.technicien=technicien;
    }
}
