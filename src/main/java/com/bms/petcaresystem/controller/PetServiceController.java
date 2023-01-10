package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.PetServiceDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.petservice.CreatePetServiceRequest;
import com.bms.petcaresystem.request.petservice.UpdatePetServiceRequest;
import com.bms.petcaresystem.request.petservice.UpdateSpeciesToPetServiceRequest;
import com.bms.petcaresystem.request.species.CreateSpeciesRequest;
import com.bms.petcaresystem.service.PetServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet-service")
@Slf4j
public class PetServiceController {
    private final PetServiceService petServiceService;

    public PetServiceController(PetServiceService petServiceService) {
        this.petServiceService = petServiceService;
    }

    @PostMapping
    public ResponseEntity<Void> createPetService(@RequestBody CreatePetServiceRequest request) {
        petServiceService.createPetService(request);

        log.info(ControllerLogMessage.PetService.PET_SERVICE_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePetService(@PathVariable String id,
                                                 @RequestBody UpdatePetServiceRequest request) {
        petServiceService.updatePetService(id, request);

        log.info(ControllerLogMessage.PetService.PET_SERVICE_UPDATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/species")
    public ResponseEntity<Void> addSpeciesToPetService(@PathVariable String id,
                                                       @RequestBody CreateSpeciesRequest request) {
        petServiceService.addSpeciesToPetService(id, request);

        log.info(ControllerLogMessage.PetService.SPECIES_ADDED_TO_PET_SERVICE);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/species/update")
    public ResponseEntity<Void> updateSpeciesToPetService(@PathVariable String id,
                                                          @RequestBody UpdateSpeciesToPetServiceRequest request) {
        petServiceService.updateSpeciesToPetService(id, request);

        log.info(ControllerLogMessage.PetService.PET_SERVICE_UPDATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/species/remove/")
    public ResponseEntity<Void> removeSpeciesToPetService(@PathVariable String id,
                                                          @RequestParam String speciesId) {
        petServiceService.removeSpeciesToPetService(id, speciesId);

        log.info(ControllerLogMessage.PetService.PET_SERVICE_UPDATED);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetService(@PathVariable String id) {
        petServiceService.deletePetService(id);

        log.info(ControllerLogMessage.PetService.PET_SERVICE_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetServiceDto> findPetServiceById(@PathVariable String id) {
        PetServiceDto petServiceDto = petServiceService.findPetServiceById(id);

        log.info(ControllerLogMessage.PetService.PET_SERVICE_FOUND);
        return ResponseEntity.ok(petServiceDto);
    }

    @GetMapping
    public ResponseEntity<List<PetServiceDto>> findALPetServices() {
        List<PetServiceDto> petServiceDtoList = petServiceService.findAllPetServices();

        log.info(ControllerLogMessage.PetService.PET_SERVICE_LISTED);
        return ResponseEntity.ok(petServiceDtoList);
    }
}
