package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.PetServiceProviderDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.petserviceprovider.CreatePetServiceProviderRequest;
import com.bms.petcaresystem.request.petserviceprovider.UpdatePetServiceProviderRequest;
import com.bms.petcaresystem.service.PetServiceProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet-service-provider")
@Slf4j
public class PetServiceProviderController {
    private final PetServiceProviderService petServiceProviderService;

    public PetServiceProviderController(PetServiceProviderService petServiceProviderService) {
        this.petServiceProviderService = petServiceProviderService;
    }

    @PostMapping
    public ResponseEntity<Void> createPetServiceProvider(@RequestBody CreatePetServiceProviderRequest request) {
        petServiceProviderService.createPetServiceProvider(request);

        log.info(ControllerLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePetServiceProvider(@PathVariable String id,
                                                         @RequestBody UpdatePetServiceProviderRequest request) {
        petServiceProviderService.updatePetServiceProvider(id, request);

        log.info(ControllerLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_UPDATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Void> completePetServiceProvider(@PathVariable String id){
        petServiceProviderService.completePetServiceProvider(id);

        log.info(ControllerLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_COMPLETED);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetServiceProvider(@PathVariable String id) {
        petServiceProviderService.deletePetServiceProvider(id);

        log.info(ControllerLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetServiceProviderDto> findPetServiceProviderById(@PathVariable String id) {
        PetServiceProviderDto petServiceProviderDto = petServiceProviderService.findPetServiceProviderById(id);

        log.info(ControllerLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_FOUND);
        return ResponseEntity.ok(petServiceProviderDto);
    }

    @GetMapping
    public ResponseEntity<List<PetServiceProviderDto>> findAllPetServiceProviders() {
        List<PetServiceProviderDto> petServiceProviderDtoList = petServiceProviderService.findAllPetServiceProviders();

        log.info(ControllerLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_LISTED);
        return ResponseEntity.ok(petServiceProviderDtoList);
    }
}
