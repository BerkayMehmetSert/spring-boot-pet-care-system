package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.PetServiceDto;
import com.bms.petcaresystem.dto.converter.PetServiceDtoConverter;
import com.bms.petcaresystem.exception.petservice.PetServiceAlreadyExistException;
import com.bms.petcaresystem.exception.petservice.PetServiceListEmptyException;
import com.bms.petcaresystem.exception.petservice.PetServiceNotFoundException;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.PetService;
import com.bms.petcaresystem.model.Species;
import com.bms.petcaresystem.repository.PetServiceRepository;
import com.bms.petcaresystem.request.petservice.CreatePetServiceRequest;
import com.bms.petcaresystem.request.petservice.UpdatePetServiceRequest;
import com.bms.petcaresystem.request.petservice.UpdateSpeciesToPetServiceRequest;
import com.bms.petcaresystem.request.species.CreateSpeciesRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PetServiceService {
    private final PetServiceRepository petServiceRepository;
    private final SpeciesService speciesService;
    private final UnitService unitService;
    private final PetServiceDtoConverter converter;

    public PetServiceService(PetServiceRepository petServiceRepository,
                             SpeciesService speciesService,
                             UnitService unitService,
                             PetServiceDtoConverter converter) {
        this.petServiceRepository = petServiceRepository;
        this.speciesService = speciesService;
        this.unitService = unitService;
        this.converter = converter;
    }

    public void createPetService(final CreatePetServiceRequest request) {
        PetService petService = new PetService();

        checkIfPetServiceExist(request.getName());

        petService.setName(request.getName());
        petService.setHasLimit(request.getHasLimit());
        petService.setCostPerUnit(request.getCostPerUnit());
        petService.setUnit(unitService.findUnitByUnitId(request.getUnitId()));
        petService.setSpecies(request.getSpecies().stream()
                .map(species -> {
                    Species petServiceSpecies = new Species();
                    petServiceSpecies.setName(species.getName());
                    return petServiceSpecies;
                })
                .collect(Collectors.toSet()));

        petServiceRepository.save(petService);
        log.info(BusinessLogMessage.PetService.PET_SERVICE_CREATED);
    }

    public void addSpeciesToPetService(final String id, final CreateSpeciesRequest request) {
        PetService petService = findPetServiceByPetServiceId(id);

        Species species = new Species();
        species.setName(request.getName());

        petService.getSpecies().add(species);

        petServiceRepository.save(petService);
        log.info(BusinessLogMessage.PetService.SPECIES_ADDED_TO_PET_SERVICE);
    }

    public void updateSpeciesToPetService(final String id, final UpdateSpeciesToPetServiceRequest request){
        PetService petService = findPetServiceByPetServiceId(id);

        Species currentlySpecies = petService.getSpecies().stream()
                .filter(s->s.getId().equals(request.getCurrentSpeciesId()))
                .findFirst()
                .orElseThrow(()->{
                    log.error(BusinessLogMessage.PetService.SPECIES_NOT_FOUND);
                    return new PetServiceNotFoundException(BusinessMessage.PetService.SPECIES_NOT_FOUND);
                });

        petService.getSpecies().remove(currentlySpecies);
        petService.getSpecies().add(speciesService.findSpeciesBySpeciesId(request.getNewSpeciesId()));

        petServiceRepository.save(petService);
        log.info(BusinessLogMessage.PetService.SPECIES_UPDATED_TO_PET_SERVICE);

    }

    public void removeSpeciesToPetService(final String id, final String speciesId){
        PetService petService = findPetServiceByPetServiceId(id);
        Species species = petService.getSpecies().stream()
                .filter(s->s.getId().equals(speciesId))
                .findFirst()
                .orElseThrow(()->{
                    log.error(BusinessLogMessage.PetService.SPECIES_NOT_FOUND);
                    return new PetServiceNotFoundException(BusinessMessage.PetService.SPECIES_NOT_FOUND);
                });

        petService.getSpecies().remove(species);

        petServiceRepository.save(petService);
        log.info(BusinessLogMessage.PetService.SPECIES_REMOVED_TO_PET_SERVICE);
    }

    public void updatePetService(final String id, final UpdatePetServiceRequest request) {
        PetService petService = findPetServiceByPetServiceId(id);

        if (!petService.getName().equals(request.getName())) {
            checkIfPetServiceExist(request.getName());
        }

        petService.setName(request.getName());
        petService.setHasLimit(request.getHasLimit());
        petService.setCostPerUnit(request.getCostPerUnit());
        petService.setUnit(unitService.findUnitByUnitId(request.getUnitId()));

        petServiceRepository.save(petService);
        log.info(BusinessLogMessage.PetService.PET_SERVICE_UPDATED);
    }

    public void deletePetService(final String id) {
        PetService petService = findPetServiceByPetServiceId(id);

        log.info(BusinessLogMessage.PetService.PET_SERVICE_DELETED);
        petServiceRepository.delete(petService);
    }

    public PetServiceDto findPetServiceById(final String id){
        PetService petService=findPetServiceByPetServiceId(id);

        log.info(BusinessLogMessage.PetService.PET_SERVICE_FIND);
        return converter.convert(petService);
    }

    public List<PetServiceDto> findAllPetServices(){
        List<PetService> petServices = petServiceRepository.findAll();

        if (petServices.isEmpty()){
            log.error(BusinessLogMessage.PetService.PET_SERVICE_LIST_EMPTY);
            throw new PetServiceListEmptyException(BusinessMessage.PetService.PET_SERVICE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.PetService.PET_SERVICE_FIND);
        return converter.convert(petServices);
    }

    protected PetService findPetServiceByPetServiceId(final String id) {
        return petServiceRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.PetService.PET_SERVICE_NOT_FOUND);
            throw new PetServiceNotFoundException(BusinessMessage.PetService.PET_SERVICE_NOT_FOUND);
        });
    }

    private void checkIfPetServiceExist(final String name) {
        if (petServiceRepository.existsByNameIgnoreCase(name)) {
            log.error(BusinessLogMessage.PetService.PET_SERVICE_ALREADY_EXISTS);
            throw new PetServiceAlreadyExistException(BusinessMessage.PetService.PET_SERVICE_ALREADY_EXISTS);
        }
    }
}
