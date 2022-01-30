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

import java.util.Optional;

import com.buildindingandco.BuildindingAndCo.repositories.VehiculeRepository;
import com.buildindingandco.BuildindingAndCo.dtos.VehiculeDto;
import com.buildindingandco.BuildindingAndCo.mapper.VehiculeMapper;
import com.buildindingandco.BuildindingAndCo.model.Vehicules;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@Api(tags = "vehicule")
@RequestMapping(produces = APPLICATION_JSON_VALUE, path = "vehicules")
public class VehiculeController {
    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehicule;

    @GetMapping(path = "{id}") 
    @ApiOperation(value = " Consulter un vehicule", response =VehiculeDto.class)
    @ApiResponses(
            value = {@ApiResponse(code = 404, message = "Ressource non trouvée"),
                    @ApiResponse(code = 200, message = "Opération réussie", response = VehiculeDto.class)})
    // /adresses/{id}
    public ResponseEntity<VehiculeDto> getById(@PathVariable Long id) {
        
        return this.vehiculeRepository.findById(id)
                .map(vehicule -> ResponseEntity.ok(map(vehicule)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ApiOperation(value = " Enregistrer un vehicule", response = VehiculeDto.class)
    @ApiResponses(
            value = {@ApiResponse(code = 404, message = "Ressource non trouvée"),
                    @ApiResponse(code = 201, message = "Adresse crée", response = VehiculeDto.class)})
    // /Adresses
    public ResponseEntity<VehiculeDto> create(@RequestBody VehiculeDto vehiculeDto) {
        Vehicules vehicule = new Vehicules();
        vehicule.setBrand(vehiculeDto.getNumPlaque());
        vehicule.setBrand(vehiculeDto.getBrand());
        vehicule.setBuiltIn(vehiculeDto.getBuiltIn());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(map(this.vehiculeRepository.save(vehicule)));
    }

    @PutMapping(path = "{id}")
    // /adresses/{id}
    @ApiOperation(value = " Modifier un vehicule ", response =VehiculeDto.class)
    @ApiResponses(
            value = {@ApiResponse(code = 404, message = "Resource Non trouvée"),
                    @ApiResponse(code = 200, message = "operation réussie", response = VehiculeDto.class)})
    public ResponseEntity<VehiculeDto> update(@PathVariable Long id, @RequestBody VehiculeDto vehiculeDto) {
        Optional<Vehicules> vehiculeOptional = this.vehiculeRepository.findById(id);
        if (vehiculeOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Vehicules vehiculeToUpdate = vehiculeOptional.get();
        vehiculeToUpdate.setBrand(vehiculeDto.getNumPlaque());
        vehiculeToUpdate.setBrand(vehiculeDto.getBrand());
        vehiculeToUpdate.setBuiltIn(vehiculeDto.getBuiltIn());
        return ResponseEntity.ok(map(this.vehiculeRepository.save(vehiculeToUpdate)));
    }

    @DeleteMapping(path = "{id}")
    @ApiOperation(value = "Supprimer un vehicule", response = VehiculeDto.class)
    @ApiResponses(
            value = {@ApiResponse(code = 404, message = "Resource Non trouvée"),
                    @ApiResponse(code = 204, message = "operation réussie")})
    // /adresses/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.vehiculeRepository.deleteById(id);
    }

    private VehiculeDto map(@NonNull Vehicules vehicule) {
        return new VehiculeDto(
            vehicule.getId(),
            vehicule.getNumPlaque(),
            vehicule.getBrand(),
            vehicule.getBuiltIn(),
            vehicule.getTechnicien()        
        );
    }

}
