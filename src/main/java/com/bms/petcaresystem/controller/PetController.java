package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.PetDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.pet.CreatePetRequest;
import com.bms.petcaresystem.request.pet.UpdatePetRequest;
import com.bms.petcaresystem.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet")
@Slf4j
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<Void> createPet(@RequestBody CreatePetRequest request) {
        petService.createPet(request);

        log.info(ControllerLogMessage.Pet.PET_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePet(@PathVariable String id, @RequestBody UpdatePetRequest request) {
        petService.updatePet(id, request);

        log.info(ControllerLogMessage.Pet.PET_UPDATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/owner/add")
    public ResponseEntity<Void> addOwnerToPet(@PathVariable String id, @RequestParam String ownerId) {
        petService.addOwnerToPet(id, ownerId);

        log.info(ControllerLogMessage.Pet.OWNER_ADDED_TO_PET);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/owner/remove")
    public ResponseEntity<Void> removeOwnerToPet(@PathVariable String id, @RequestParam String ownerId) {
        petService.removeOwnerToPet(id, ownerId);

        log.info(ControllerLogMessage.Pet.OWNER_REMOVED_TO_PET);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable String id) {
        petService.deletePet(id);

        log.info(ControllerLogMessage.Pet.PET_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> findPetById(@PathVariable String id) {
        PetDto petDto = petService.findPetById(id);

        log.info(ControllerLogMessage.Pet.PET_FOUND);
        return ResponseEntity.ok(petDto);
    }

    @GetMapping
    public ResponseEntity<List<PetDto>> findAllPets() {
        List<PetDto> petDtoList = petService.findAllPets();

        log.info(ControllerLogMessage.Pet.PET_LISTED);
        return ResponseEntity.ok(petDtoList);
    }
}
