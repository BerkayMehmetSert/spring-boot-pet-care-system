package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.PetServiceProviderDto;
import com.bms.petcaresystem.dto.converter.PetServiceProviderDtoConverter;
import com.bms.petcaresystem.exception.petserviceprovider.PetServiceProviderListEmptyException;
import com.bms.petcaresystem.exception.petserviceprovider.PetServiceProviderNotFoundException;
import com.bms.petcaresystem.helper.DateHelper;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.PetServiceProvider;
import com.bms.petcaresystem.repository.PetServiceProviderRepository;
import com.bms.petcaresystem.request.petserviceprovider.CreatePetServiceProviderRequest;
import com.bms.petcaresystem.request.petserviceprovider.UpdatePetServiceProviderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PetServiceProviderService {
    private final PetServiceProviderRepository petServiceProviderRepository;
    private final PetServiceService petServiceService;
    private final PetCaseService petCaseService;
    private final PetServiceProviderDtoConverter converter;

    public PetServiceProviderService(PetServiceProviderRepository petServiceProviderRepository,
                                     PetServiceService petServiceService,
                                     PetCaseService petCaseService,
                                     PetServiceProviderDtoConverter converter) {
        this.petServiceProviderRepository = petServiceProviderRepository;
        this.petServiceService = petServiceService;
        this.petCaseService = petCaseService;
        this.converter = converter;
    }

    public void createPetServiceProvider(final CreatePetServiceProviderRequest request) {
        PetServiceProvider petServiceProvider = new PetServiceProvider();

        petServiceProvider.setStartTime(DateHelper.getCurrentDateTime());
        petServiceProvider.setUnits(request.getUnits());
        petServiceProvider.setCostPerUnit(request.getCostPerUnit());
        petServiceProvider.setNotes(request.getNotes());
        petServiceProvider.setPetService(petServiceService.findPetServiceByPetServiceId(request.getPetServiceId()));
        petServiceProvider.setPetCase(petCaseService.findPetCaseByPetCaseId(request.getPetCaseId()));
        petServiceProvider.setPriceCharge(calculatePriceCharge(request.getCostPerUnit(), request.getUnits()));

        petServiceProviderRepository.save(petServiceProvider);
        log.info(BusinessLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_CREATED);
    }

    public void updatePetServiceProvider(final String id, final UpdatePetServiceProviderRequest request) {
        PetServiceProvider petServiceProvider = findPetServiceProviderByPetServiceProviderId(id);

        petServiceProvider.setStartTime(DateHelper.getCurrentDateTime());
        petServiceProvider.setUnits(request.getUnits());
        petServiceProvider.setCostPerUnit(request.getCostPerUnit());
        petServiceProvider.setNotes(request.getNotes());
        petServiceProvider.setPetService(petServiceService.findPetServiceByPetServiceId(request.getPetServiceId()));
        petServiceProvider.setPetCase(petCaseService.findPetCaseByPetCaseId(request.getPetServiceId()));
        petServiceProvider.setPriceCharge(calculatePriceCharge(request.getCostPerUnit(), request.getUnits()));

        petServiceProviderRepository.save(petServiceProvider);
        log.info(BusinessLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_UPDATED);
    }

    public void completePetServiceProvider(final String id) {
        PetServiceProvider petServiceProvider = findPetServiceProviderByPetServiceProviderId(id);

        petServiceProvider.setEndTime(DateHelper.getCurrentDateTime());

        petServiceProviderRepository.save(petServiceProvider);
        log.info(BusinessLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_COMPLETED);
    }

    public void deletePetServiceProvider(final String id) {
        PetServiceProvider petServiceProvider = findPetServiceProviderByPetServiceProviderId(id);

        petServiceProviderRepository.delete(petServiceProvider);
        log.info(BusinessLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_DELETED);
    }

    public PetServiceProviderDto findPetServiceProviderById(final String id) {
        PetServiceProvider petServiceProvider = findPetServiceProviderByPetServiceProviderId(id);

        log.info(BusinessLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_FIND);
        return converter.convert(petServiceProvider);
    }

    public List<PetServiceProviderDto> findAllPetServiceProviders() {
        List<PetServiceProvider> petServiceProviders = petServiceProviderRepository.findAll();

        if (petServiceProviders.isEmpty()) {
            log.error(BusinessLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_LIST_EMPTY);
            throw new PetServiceProviderListEmptyException(BusinessMessage
                    .PetServiceProvider.PET_SERVICE_PROVIDER_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_LIST);
        return converter.convert(petServiceProviders);
    }

    protected PetServiceProvider findPetServiceProviderByPetServiceProviderId(final String id) {
        return petServiceProviderRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.PetServiceProvider.PET_SERVICE_PROVIDER_NOT_FOUND);
            throw new PetServiceProviderNotFoundException(BusinessMessage
                    .PetServiceProvider.PET_SERVICE_PROVIDER_NOT_FOUND);
        });
    }

    private Double calculatePriceCharge(final Double costPerUnit, final Integer units) {
        return costPerUnit * Double.valueOf(units);
    }
}
