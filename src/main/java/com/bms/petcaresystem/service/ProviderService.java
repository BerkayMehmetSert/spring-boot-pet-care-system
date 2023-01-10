package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.ProviderDto;
import com.bms.petcaresystem.dto.converter.ProviderDtoConverter;
import com.bms.petcaresystem.exception.provider.ProviderListEmptyException;
import com.bms.petcaresystem.exception.provider.ProviderNotFoundException;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.Provider;
import com.bms.petcaresystem.repository.PetServiceRepository;
import com.bms.petcaresystem.repository.ProviderRepository;
import com.bms.petcaresystem.request.provider.CreateProviderRequest;
import com.bms.petcaresystem.request.provider.UpdateProviderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProviderService {
    private final ProviderRepository providerRepository;
    private final FacilityService facilityService;
    private final PetServiceService petServiceService;
    private final ProviderDtoConverter converter;

    public ProviderService(ProviderRepository providerRepository,
                           FacilityService facilityService,
                           PetServiceService petServiceService,
                           ProviderDtoConverter converter) {
        this.providerRepository = providerRepository;
        this.facilityService = facilityService;
        this.petServiceService = petServiceService;
        this.converter = converter;
    }

    public void createProvider(final CreateProviderRequest request) {
        Provider provider = new Provider();

        provider.setServiceLimit(request.getServiceLimit());
        provider.setCurrentlyUsed(request.getCurrentlyUsed());
        provider.setFacility(facilityService.findFacilityByFacilityId(request.getFacilityId()));
        provider.setPetService(petServiceService.findPetServiceByPetServiceId(request.getPetServiceId()));

        providerRepository.save(provider);
        log.info(BusinessLogMessage.Provider.PROVIDER_CREATED);
    }


    public void updateProvider(final String id, final UpdateProviderRequest request) {
        Provider provider = findProviderByProviderId(id);

        provider.setServiceLimit(request.getServiceLimit());
        provider.setCurrentlyUsed(request.getCurrentlyUsed());
        provider.setFacility(facilityService.findFacilityByFacilityId(request.getFacilityId()));
        provider.setPetService(petServiceService.findPetServiceByPetServiceId(request.getPetServiceId()));

        providerRepository.save(provider);
        log.info(BusinessLogMessage.Provider.PROVIDER_UPDATED);
    }

    public void deleteProvider(final String id) {
        Provider provider = findProviderByProviderId(id);

        providerRepository.delete(provider);
        log.info(BusinessLogMessage.Provider.PROVIDER_DELETED);
    }

    public ProviderDto findProviderById(final String id) {
        Provider provider = findProviderByProviderId(id);

        log.info(BusinessLogMessage.Provider.PROVIDER_FIND);
        return converter.convert(provider);
    }

    public List<ProviderDto> findAllProviders() {
        List<Provider> providers = providerRepository.findAll();

        if (providers.isEmpty()) {
            log.error(BusinessLogMessage.Provider.PROVIDER_LIST_EMPTY);
            throw new ProviderListEmptyException(BusinessMessage.Provider.PROVIDER_LIST_EMPTY);
        }

        log.info(BusinessMessage.Provider.PROVIDER_LISTED);
        return converter.convert(providers);
    }

    protected Provider findProviderByProviderId(final String id) {
        return providerRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Provider.PROVIDER_NOT_FOUND);
            throw new ProviderNotFoundException(BusinessMessage.Provider.PROVIDER_NOT_FOUND);
        });
    }
}
