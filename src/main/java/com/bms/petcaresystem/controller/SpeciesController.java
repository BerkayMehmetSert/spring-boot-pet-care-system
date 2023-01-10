package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.SpeciesDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.species.UpdateSpeciesRequest;
import com.bms.petcaresystem.service.SpeciesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/species")
@Slf4j
public class SpeciesController {
    private final SpeciesService speciesService;

    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSpecies(@PathVariable String id,
                                              @RequestBody UpdateSpeciesRequest request) {
        speciesService.updateSpecies(id, request);

        log.info(ControllerLogMessage.Species.SPECIES_UPDATED);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecies(@PathVariable String id) {
        speciesService.deleteSpecies(id);

        log.info(ControllerLogMessage.Species.SPECIES_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpeciesDto> findSpeciesById(@PathVariable String id) {
        SpeciesDto speciesDto = speciesService.findSpeciesById(id);

        log.info(ControllerLogMessage.Species.SPECIES_FOUND);
        return ResponseEntity.ok(speciesDto);
    }

    @GetMapping
    public ResponseEntity<List<SpeciesDto>> findAllSpecies() {
        List<SpeciesDto> speciesDtoList = speciesService.findAlSpecies();

        log.info(ControllerLogMessage.Species.SPECIES_LISTED);
        return ResponseEntity.ok(speciesDtoList);
    }
}
