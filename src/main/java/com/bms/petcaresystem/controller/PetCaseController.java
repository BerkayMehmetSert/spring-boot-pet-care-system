package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.PetCaseDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.petcase.CreatePetCaseRequest;
import com.bms.petcaresystem.request.petcase.UpdatePetCaseRequest;
import com.bms.petcaresystem.service.PetCaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet-case")
@Slf4j
public class PetCaseController {
    private final PetCaseService petCaseService;

    public PetCaseController(PetCaseService petCaseService) {
        this.petCaseService = petCaseService;
    }

    @PostMapping
    public ResponseEntity<Void> createPetCase(@RequestBody CreatePetCaseRequest request) {
        petCaseService.createPetCase(request);

        log.info(ControllerLogMessage.PetCase.PET_CASE_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePetCase(@PathVariable String id, @RequestBody UpdatePetCaseRequest request) {
        petCaseService.updatePetCase(id, request);

        log.info(ControllerLogMessage.PetCase.PET_CASE_UPDATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Void> completePetCase(@PathVariable String id) {
        petCaseService.completePetCase(id);

        log.info(ControllerLogMessage.PetCase.PET_CASE_COMPLETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetCaseDto> findPetCaseById(@PathVariable String id) {
        PetCaseDto petCaseDto = petCaseService.findPetCaseById(id);

        log.info(ControllerLogMessage.PetCase.PET_CASE_FOUND);
        return ResponseEntity.ok(petCaseDto);
    }

    @GetMapping
    public ResponseEntity<List<PetCaseDto>> findALPetCases() {
        List<PetCaseDto> petCaseDtoList = petCaseService.findAllPetCases();

        log.info(ControllerLogMessage.PetCase.PET_CASE_LISTED);
        return ResponseEntity.ok(petCaseDtoList);
    }
}
