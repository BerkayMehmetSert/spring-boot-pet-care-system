package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.PetDto;
import com.bms.petcaresystem.dto.converter.PetDtoConverter;
import com.bms.petcaresystem.exception.pet.PetListEmptyException;
import com.bms.petcaresystem.exception.pet.PetNotFoundException;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.Owner;
import com.bms.petcaresystem.model.Pet;
import com.bms.petcaresystem.repository.PetRepository;
import com.bms.petcaresystem.request.pet.CreatePetRequest;
import com.bms.petcaresystem.request.pet.UpdatePetRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PetService {
    private final PetRepository petRepository;
    private final SpeciesService speciesService;
    private final OwnerService ownerService;
    private final PetDtoConverter converter;

    public PetService(PetRepository petRepository,
                      SpeciesService speciesService,
                      OwnerService ownerService,
                      PetDtoConverter converter) {
        this.petRepository = petRepository;
        this.speciesService = speciesService;
        this.ownerService = ownerService;
        this.converter = converter;
    }

    public void createPet(final CreatePetRequest request) {
        Pet pet = new Pet();

        pet.setName(request.getName());
        pet.setBirthDate(request.getBirthDate());
        pet.setNotes(request.getNotes());
        pet.setSpecies(speciesService.findSpeciesBySpeciesId(request.getSpeciesId()));
        pet.setOwners(request.getOwners().stream()
                .map(owner -> {
                    Owner newOwner = new Owner();
                    newOwner.setFirstName(owner.getFirstName());
                    newOwner.setLastName(owner.getLastName());
                    newOwner.setPhone(owner.getPhone());
                    newOwner.setEmail(owner.getEmail());
                    newOwner.setNotes(owner.getNotes());
                    return newOwner;
                })
                .collect(Collectors.toSet())
        );

        petRepository.save(pet);
        log.info(BusinessLogMessage.Pet.PET_CREATED);
    }

    public void updatePet(final String id, final UpdatePetRequest request) {
        Pet pet = findPetByPetId(id);

        pet.setName(request.getName());
        pet.setBirthDate(request.getBirthDate());
        pet.setNotes(request.getNotes());
        pet.setSpecies(speciesService.findSpeciesBySpeciesId(request.getSpeciesId()));

        petRepository.save(pet);
        log.info(BusinessLogMessage.Pet.PET_UPDATED);
    }

    public void addOwnerToPet(final String petId, final String ownerId) {
        Pet pet = findPetByPetId(petId);

        pet.getOwners().add(ownerService.findOwnerByOwnerId(ownerId));

        petRepository.save(pet);
        log.info(BusinessLogMessage.Pet.PET_OWNER_ADDED);
    }

    public void removeOwnerToPet(final String id, final String ownerId) {
        Pet pet = findPetByPetId(id);

        pet.getOwners().remove(ownerService.findOwnerByOwnerId(ownerId));

        petRepository.save(pet);
        log.info(BusinessLogMessage.Pet.PET_OWNER_REMOVED);
    }

    public void deletePet(final String id) {
        Pet pet = findPetByPetId(id);

        petRepository.delete(pet);
        log.info(BusinessLogMessage.Pet.PET_DELETED);
    }

    public PetDto findPetById(final String id) {
        Pet pet = findPetByPetId(id);

        log.info(BusinessLogMessage.Pet.PET_FIND);
        return converter.convert(pet);
    }

    public List<PetDto> findAllPets() {
        List<Pet> pets = petRepository.findAll();

        if (pets.isEmpty()) {
            log.error(BusinessLogMessage.Pet.PET_LIST_EMPTY);
            throw new PetListEmptyException(BusinessMessage.Pet.PET_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Pet.PET_LIST);
        return converter.convert(pets);
    }

    protected Pet findPetByPetId(final String id) {
        return petRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Pet.PET_NOT_FOUND);
            throw new PetNotFoundException(BusinessMessage.Pet.PET_NOT_FOUND);
        });
    }
}
