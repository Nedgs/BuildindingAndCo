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
import com.buildindingandco.BuildindingAndCo.dtos.WorksiteDto;
import com.buildindingandco.BuildindingAndCo.mapper.WorksiteMapper;
import com.buildindingandco.BuildindingAndCo.model.Worksite;
import com.buildindingandco.BuildindingAndCo.repositories.WorksiteRepository;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@Api(tags = "worksite")
@RequestMapping(produces = APPLICATION_JSON_VALUE, path = "worksites")


public class WorksiteController {
    private final WorksiteRepository worksiteRepository;
    private final WorksiteMapper worksite;

    @GetMapping(path = "{id}") 
    @ApiOperation(value = " Consulter une chantier ", response = WorksiteDto.class)
    @ApiResponses(
            value = {@ApiResponse(code = 404, message = "Ressource non trouvée"),
                    @ApiResponse(code = 200, message = "Opération réussie", response = WorksiteDto.class)})
    // /adresses/{id}
    public ResponseEntity<WorksiteDto> getById(@PathVariable Long id) {
        
        return this.worksiteRepository.findById(id)
                .map(worksite -> ResponseEntity.ok(map(worksite)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ApiOperation(value = " Enregistrer un chantier", response = WorksiteDto.class)
    @ApiResponses(
            value = {@ApiResponse(code = 404, message = "Ressource non trouvée"),
                    @ApiResponse(code = 201, message = "Adresse crée", response = WorksiteDto.class)})
    // /Adresses
    public ResponseEntity<WorksiteDto> create(@RequestBody WorksiteDto worksiteDto) {
        Worksite worksite = new Worksite();
        worksite.setName(worksiteDto.getName());
        worksite.setPrice(worksiteDto.getPrice());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(map(this.worksiteRepository.save(worksite)));
    }

    @PutMapping(path = "{id}")
    // /adresses/{id}
    @ApiOperation(value = " Modifier un chaniter ", response =WorksiteDto.class)
    @ApiResponses(
            value = {@ApiResponse(code = 404, message = "Resource Non trouvée"),
                    @ApiResponse(code = 200, message = "operation réussie", response = WorksiteDto.class)})
    public ResponseEntity<WorksiteDto> update(@PathVariable Long id, @RequestBody WorksiteDto worksiteDto) {
        Optional<Worksite> worksiteOptional = this.worksiteRepository.findById(id);
        if (worksiteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Worksite worksiteToUpdate = worksiteOptional.get();
        worksiteToUpdate.setName(worksiteDto.getName());
        worksiteToUpdate.setPrice(worksiteDto.getPrice());
        return ResponseEntity.ok(map(this.worksiteRepository.save(worksiteToUpdate)));
    }

    @DeleteMapping(path = "{id}")
    @ApiOperation(value = "Supprimer un chantier", response = WorksiteDto.class)
    @ApiResponses(
            value = {@ApiResponse(code = 404, message = "Resource Non trouvée"),
                    @ApiResponse(code = 204, message = "operation réussie")})
    // /adresses/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.worksiteRepository.deleteById(id);
    }

    private WorksiteDto map(@NonNull Worksite worksite) {
        return new WorksiteDto(
                worksite.getId(),
                worksite.getName(),
                worksite.getPrice(),
                worksite.getAdress(),
                worksite.getTechniciens()        
        );
    }


}
