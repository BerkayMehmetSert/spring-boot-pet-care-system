package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.OwnerDto;
import com.bms.petcaresystem.dto.converter.OwnerDtoConverter;
import com.bms.petcaresystem.exception.owner.OwnerAlreadyExistException;
import com.bms.petcaresystem.exception.owner.OwnerListEmptyException;
import com.bms.petcaresystem.exception.owner.OwnerNotFoundException;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.Owner;
import com.bms.petcaresystem.repository.OwnerRepository;
import com.bms.petcaresystem.request.owner.CreateOwnerRequest;
import com.bms.petcaresystem.request.owner.UpdateOwnerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerDtoConverter converter;

    public OwnerService(OwnerRepository ownerRepository,
                        OwnerDtoConverter converter) {
        this.ownerRepository = ownerRepository;
        this.converter = converter;
    }

    public void createOwner(final CreateOwnerRequest request) {
        Owner owner = new Owner();

        checkIfOwnerExists(request.getFirstName(), request.getLastName());

        owner.setFirstName(request.getFirstName());
        owner.setLastName(request.getLastName());
        owner.setEmail(request.getEmail());
        owner.setPhone(request.getPhone());
        owner.setNotes(request.getNotes());

        ownerRepository.save(owner);
        log.info(BusinessLogMessage.Owner.OWNER_CREATED);
    }

    public void updateOwner(final String id, final UpdateOwnerRequest request) {
        Owner owner = findOwnerByOwnerId(id);

        if (!owner.getFirstName().equals(request.getFirstName()) || owner.getLastName().equals(request.getLastName())) {
            checkIfOwnerExists(request.getFirstName(), request.getLastName());
        }

        owner.setFirstName(request.getFirstName());
        owner.setLastName(request.getLastName());
        owner.setEmail(request.getEmail());
        owner.setPhone(request.getPhone());
        owner.setNotes(request.getNotes());

        ownerRepository.save(owner);
        log.info(BusinessLogMessage.Owner.OWNER_UPDATED);
    }

    public void deleteOwner(final String id) {
        Owner owner = findOwnerByOwnerId(id);

        ownerRepository.delete(owner);
        log.info(BusinessLogMessage.Owner.OWNER_DELETED);
    }

    public OwnerDto findOwnerById(final String id) {
        Owner owner = findOwnerByOwnerId(id);

        log.info(BusinessLogMessage.Owner.OWNER_FIND);
        return converter.convert(owner);
    }

    public List<OwnerDto> findAllOwners() {
        List<Owner> owners = ownerRepository.findAll();

        if (owners.isEmpty()) {
            log.error(BusinessLogMessage.Owner.OWNER_LIST_EMPTY);
            throw new OwnerListEmptyException(BusinessMessage.Owner.OWNER_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Owner.OWNER_LIST);
        return converter.convert(owners);
    }

    private void checkIfOwnerExists(final String firsName, final String lastName) {
        if (ownerRepository.existsByFirstNameIgnoreCaseAndLastNameIgnoreCase(firsName, lastName)) {
            log.error(BusinessLogMessage.Owner.OWNER_ALREADY_EXISTS);
            throw new OwnerAlreadyExistException(BusinessMessage.Owner.OWNER_ALREADY_EXISTS);
        }
    }

    protected Owner findOwnerByOwnerId(final String id) {
        return ownerRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Owner.OWNER_NOT_FOUND);
            throw new OwnerNotFoundException(BusinessMessage.Owner.OWNER_NOT_FOUND);
        });
    }
}
