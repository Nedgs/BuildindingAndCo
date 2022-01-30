package com.buildindingandco.BuildindingAndCo.controller;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.buildindingandco.BuildindingAndCo.dtos.AdressDto;
import com.buildindingandco.BuildindingAndCo.mapper.AdressMapper;
import com.buildindingandco.BuildindingAndCo.model.Adress;
import com.buildindingandco.BuildindingAndCo.repositories.AdressRepository;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@Api(tags = "adress")
@RequestMapping(produces = APPLICATION_JSON_VALUE, path = "adresses")

public class AdressController {


    private final AdressRepository adressRepository;
    private final AdressMapper mapper;

    @GetMapping(path = "{id}") 
    @ApiOperation(value = " Consulter une adresse ", response = AdressDto.class)
    @ApiResponses(
            value = {@ApiResponse(code = 404, message = "Ressource non trouvée"),
                    @ApiResponse(code = 200, message = "Opération réussie", response = AdressDto.class)})
    // /adresses/{id}
    public ResponseEntity<AdressDto> getById(@PathVariable Long id) {
        
        return this.adressRepository.findById(id)
                .map(adress -> ResponseEntity.ok(map(adress)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ApiOperation(value = " Enregistrer une adresse ", response = AdressDto.class)
    @ApiResponses(
            value = {@ApiResponse(code = 404, message = "Ressource non trouvée"),
                    @ApiResponse(code = 201, message = "Adresse crée", response = AdressDto.class)})
    // /Adresses
    public ResponseEntity<AdressDto> create(@RequestBody AdressDto adressDto) {
        Adress adress = new Adress();
        adress.setCityName(adressDto.getCityName());
        adress.setStreet(adressDto.getStreet());
        adress.setStreetNumber(adressDto.getStreetNumber());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(map(this.adressRepository.save(adress)));
    }

    @PutMapping(path = "{id}")
    // /adresses/{id}
    @ApiOperation(value = " Modifier une adresse ", response =AdressDto.class)
    @ApiResponses(
            value = {@ApiResponse(code = 404, message = "Resource Non trouvée"),
                    @ApiResponse(code = 200, message = "operation réussie", response = AdressDto.class)})
    public ResponseEntity<AdressDto> update(@PathVariable Long id, @RequestBody AdressDto adressDto) {
        Optional<Adress> adressOptional = this.adressRepository.findById(id);
        if (adressOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Adress adressToUpdate = adressOptional.get();
        adressToUpdate.setCityName(adressDto.getCityName());
        adressToUpdate.setStreet(adressDto.getStreet());
        adressToUpdate.setStreetNumber(adressDto.getStreetNumber());
        return ResponseEntity.ok(map(this.adressRepository.save(adressToUpdate)));
    }

    @DeleteMapping(path = "{id}")
    @ApiOperation(value = "Supprimer une adresse ", response = AdressDto.class)
    @ApiResponses(
            value = {@ApiResponse(code = 404, message = "Resource Non trouvée"),
                    @ApiResponse(code = 204, message = "operation réussie")})
    // /adresses/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.adressRepository.deleteById(id);
    }

    private AdressDto map(@NonNull Adress adress) {
        return new AdressDto(
                adress.getId(),
                adress.getCityName(),
                adress.getStreet(),
                adress.getStreetNumber()        
        );
    }




}
