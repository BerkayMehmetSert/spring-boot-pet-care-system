package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.PetCaseDto;
import com.bms.petcaresystem.dto.converter.PetCaseDtoConverter;
import com.bms.petcaresystem.exception.petcase.PetCaseListEmptyException;
import com.bms.petcaresystem.exception.petcase.PetCaseNotFoundException;
import com.bms.petcaresystem.helper.DateHelper;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.PetCase;
import com.bms.petcaresystem.repository.PetCaseRepository;
import com.bms.petcaresystem.request.petcase.CreatePetCaseRequest;
import com.bms.petcaresystem.request.petcase.UpdatePetCaseRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PetCaseService {
    private final PetCaseRepository petCaseRepository;
    private final PetService petService;
    private final FacilityService facilityService;
    private final PetCaseDtoConverter converter;

    public PetCaseService(PetCaseRepository petCaseRepository,
                          PetService petService,
                          FacilityService facilityService,
                          PetCaseDtoConverter converter) {
        this.petCaseRepository = petCaseRepository;
        this.petService = petService;
        this.facilityService = facilityService;
        this.converter = converter;
    }

    public void createPetCase(final CreatePetCaseRequest request) {
        PetCase petCase = new PetCase();

        petCase.setStartTime(DateHelper.getCurrentDateTime());
        petCase.setIsActive(true);
        petCase.setPet(petService.findPetByPetId(request.getPetId()));
        petCase.setFacility(facilityService.findFacilityByFacilityId(request.getFacilityId()));

        petCaseRepository.save(petCase);
        log.info(BusinessLogMessage.PetCase.PET_CASE_CREATED);
    }

    public void updatePetCase(final String id, final UpdatePetCaseRequest request) {
        PetCase petCase = findPetCaseByPetCaseId(id);

        petCase.setPet(petService.findPetByPetId(request.getPetId()));
        petCase.setFacility(facilityService.findFacilityByFacilityId(request.getFacilityId()));

        petCaseRepository.save(petCase);
        log.info(BusinessLogMessage.PetCase.PET_CASE_UPDATED);
    }

    public void completePetCase(final String id) {
        PetCase petCase = findPetCaseByPetCaseId(id);

        petCase.setEndTime(DateHelper.getCurrentDateTime());
        petCase.setIsActive(false);

        petCaseRepository.save(petCase);
        log.info(BusinessLogMessage.PetCase.PET_CASE_COMPLETED);
    }

    public PetCaseDto findPetCaseById(final String id) {
        PetCase petCase = findPetCaseByPetCaseId(id);

        log.info(BusinessLogMessage.PetCase.PET_CASE_FIND);
        return converter.convert(petCase);
    }

    public List<PetCaseDto> findAllPetCases() {
        List<PetCase> petCases = petCaseRepository.findAll();

        if (petCases.isEmpty()) {
            log.error(BusinessLogMessage.PetCase.PET_CASE_LIST_EMPTY);
            throw new PetCaseListEmptyException(BusinessMessage.PetCase.PET_CASE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.PetCase.PET_CASE_LIST);
        return converter.convert(petCases);
    }

    protected PetCase findPetCaseByPetCaseId(final String id) {
        return petCaseRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.PetCase.PET_CASE_NOT_FOUND);
                    throw new PetCaseNotFoundException(BusinessMessage.PetCase.PET_CASE_NOT_FOUND);
                });
    }
}
