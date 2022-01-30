package com.buildindingandco.BuildindingAndCo.dtos;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel(value = "adress")
public class AdressDto {
    @ApiModelProperty(notes = "id de l'adresse", name = "id", value = "1")
    Long id;

    @ApiModelProperty(notes = "nom de la ville", name = "cityName", value = "Paris")
    String cityName;

    @ApiModelProperty(notes = "nom de la rue", name = "street", value = "rue François Mitterand")
    String street;

    @ApiModelProperty(notes = "numéro de la rue", name = "streetNumber", value = "23")
    int streetNumber;

    public AdressDto(Long id,
    String cityName,
    String street,
    int streetNumber){
        this.id=id;
        this.cityName=cityName;
        this.street=street;
        this.streetNumber=streetNumber;
    }

}
