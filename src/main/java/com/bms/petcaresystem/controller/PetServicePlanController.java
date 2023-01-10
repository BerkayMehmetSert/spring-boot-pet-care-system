package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.PetServicePlanDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.petserviceplan.CreatePetServicePlanRequest;
import com.bms.petcaresystem.request.petserviceplan.UpdatePetServicePlanRequest;
import com.bms.petcaresystem.service.PetServicePlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet-service-plan")
@Slf4j
public class PetServicePlanController {
    private final PetServicePlanService petServicePlanService;

    public PetServicePlanController(PetServicePlanService petServicePlanService) {
        this.petServicePlanService = petServicePlanService;
    }

    @PostMapping
    public ResponseEntity<Void> createPetServicePlan(@RequestBody CreatePetServicePlanRequest request) {
        petServicePlanService.createPetServicePlan(request);

        log.info(ControllerLogMessage.PetServicePlan.PET_SERVICE_PLAN_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePetServicePlan(@PathVariable String id,
                                                     @RequestBody UpdatePetServicePlanRequest request) {
        petServicePlanService.updatePetServicePlan(id, request);

        log.info(ControllerLogMessage.PetServicePlan.PET_SERVICE_PLAN_UPDATED);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetServicePlan(@PathVariable String id) {
        petServicePlanService.deletePetServicePlan(id);

        log.info(ControllerLogMessage.PetServicePlan.PET_SERVICE_PLAN_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetServicePlanDto> findPetServicePlanById(@PathVariable String id) {
        PetServicePlanDto petServicePlanDto = petServicePlanService.findPetServicePlanById(id);

        log.info(ControllerLogMessage.PetServicePlan.PET_SERVICE_PLAN_FOUND);
        return ResponseEntity.ok(petServicePlanDto);
    }

    @GetMapping
    public ResponseEntity<List<PetServicePlanDto>> findAllPetServicePlans() {
        List<PetServicePlanDto> petServicePlanDtoList = petServicePlanService.findAllPetServicePlans();

        log.info(ControllerLogMessage.PetServicePlan.PET_SERVICE_PLAN_LISTED);
        return ResponseEntity.ok(petServicePlanDtoList);
    }
}
