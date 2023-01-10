package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.PetServicePlanDto;
import com.bms.petcaresystem.dto.converter.PetServicePlanDtoConverter;
import com.bms.petcaresystem.exception.petserviceplan.PetServicePlanListEmptyException;
import com.bms.petcaresystem.exception.petserviceplan.PetServicePlanNotFoundException;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.PetServicePlan;
import com.bms.petcaresystem.repository.PetServicePlanRepository;
import com.bms.petcaresystem.request.petserviceplan.CreatePetServicePlanRequest;
import com.bms.petcaresystem.request.petserviceplan.UpdatePetServicePlanRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PetServicePlanService {
    private final PetServicePlanRepository petServicePlanRepository;
    private final PetServiceService petServiceService;
    private final PetCaseService petCaseService;
    private final PetServicePlanDtoConverter converter;

    public PetServicePlanService(PetServicePlanRepository petServicePlanRepository,
                                 PetServiceService petServiceService,
                                 PetCaseService petCaseService,
                                 PetServicePlanDtoConverter converter) {
        this.petServicePlanRepository = petServicePlanRepository;
        this.petServiceService = petServiceService;
        this.petCaseService = petCaseService;
        this.converter = converter;
    }

    public void createPetServicePlan(final CreatePetServicePlanRequest request) {
        PetServicePlan petServicePlan = new PetServicePlan();

        petServicePlan.setPlannedStartTime(request.getPlannedStartTime());
        petServicePlan.setPlannedEndTime(request.getPlannedEndTime());
        petServicePlan.setPlannedUnits(request.getPlannedUnits());
        petServicePlan.setCostPerUnit(request.getCostPerUnit());
        petServicePlan.setNotes(request.getNotes());
        petServicePlan.setPetService(petServiceService.findPetServiceByPetServiceId(request.getPetServiceId()));
        petServicePlan.setPetCase(petCaseService.findPetCaseByPetCaseId(request.getPetCaseId()));
        petServicePlan.setPlannedPrice(calculatePlannedPrice(request.getPlannedUnits(), request.getCostPerUnit()));

        petServicePlanRepository.save(petServicePlan);
        log.info(BusinessLogMessage.PetServicePlan.PET_SERVICE_PLAN_CREATED);
    }

    public void updatePetServicePlan(final String id, final UpdatePetServicePlanRequest request) {
        PetServicePlan petServicePlan = findPetServicePlanByPetServicePlanId(id);

        petServicePlan.setPlannedStartTime(request.getPlannedStartTime());
        petServicePlan.setPlannedEndTime(request.getPlannedEndTime());
        petServicePlan.setPlannedUnits(request.getPlannedUnits());
        petServicePlan.setCostPerUnit(request.getCostPerUnit());
        petServicePlan.setNotes(request.getNotes());
        petServicePlan.setPetService(petServiceService.findPetServiceByPetServiceId(request.getPetServiceId()));
        petServicePlan.setPetCase(petCaseService.findPetCaseByPetCaseId(request.getPetCaseId()));
        petServicePlan.setPlannedPrice(calculatePlannedPrice(request.getPlannedUnits(), request.getCostPerUnit()));

        petServicePlanRepository.save(petServicePlan);
        log.info(BusinessLogMessage.PetServicePlan.PET_SERVICE_PLAN_UPDATED);
    }

    public void deletePetServicePlan(final String id) {
        PetServicePlan petServicePlan = findPetServicePlanByPetServicePlanId(id);

        petServicePlanRepository.delete(petServicePlan);
        log.info(BusinessLogMessage.PetServicePlan.PET_SERVICE_PLAN_DELETED);
    }

    public PetServicePlanDto findPetServicePlanById(final String id) {
        PetServicePlan petServicePlan = findPetServicePlanByPetServicePlanId(id);

        log.info(BusinessLogMessage.PetServicePlan.PET_SERVICE_PLAN_FIND);
        return converter.convert(petServicePlan);
    }

    public List<PetServicePlanDto> findAllPetServicePlans() {
        List<PetServicePlan> petServicePlans = petServicePlanRepository.findAll();

        if (petServicePlans.isEmpty()) {
            log.error(BusinessLogMessage.PetServicePlan.PET_SERVICE_PLAN_LIST_EMPTY);
            throw new PetServicePlanListEmptyException(BusinessMessage.PetServicePlan.PET_SERVICE_PLAN_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.PetServicePlan.PET_SERVICE_PLAN_LIST);
        return converter.convert(petServicePlans);
    }

    protected PetServicePlan findPetServicePlanByPetServicePlanId(final String id) {
        return petServicePlanRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.PetServicePlan.PET_SERVICE_PLAN_NOT_FOUND);
            throw new PetServicePlanNotFoundException(BusinessMessage.PetServicePlan.PET_SERVICE_PLAN_NOT_FOUND);
        });
    }

    private Double calculatePlannedPrice(final Integer plannedUnits, final Double costPerUnit) {
        return Double.valueOf(plannedUnits) * costPerUnit;
    }
}
