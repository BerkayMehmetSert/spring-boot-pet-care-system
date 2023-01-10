package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.FacilityDto;
import com.bms.petcaresystem.dto.converter.FacilityDtoConverter;
import com.bms.petcaresystem.exception.facility.FacilityAlreadyExistException;
import com.bms.petcaresystem.exception.facility.FacilityListEmptyException;
import com.bms.petcaresystem.exception.facility.FacilityNotFoundException;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.Address;
import com.bms.petcaresystem.model.Facility;
import com.bms.petcaresystem.repository.FacilityRepository;
import com.bms.petcaresystem.request.address.UpdateAddressRequest;
import com.bms.petcaresystem.request.facility.CreateFacilityRequest;
import com.bms.petcaresystem.request.facility.UpdateFacilityRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FacilityService {
    private final FacilityRepository facilityRepository;
    private final FacilityDtoConverter converter;

    public FacilityService(FacilityRepository facilityRepository,
                           FacilityDtoConverter converter) {
        this.facilityRepository = facilityRepository;
        this.converter = converter;
    }

    public void createFacility(final CreateFacilityRequest request) {
        Facility facility = new Facility();
        Address address = new Address();

        address.setStreet(request.getAddress().getStreet());
        address.setCity(request.getAddress().getCity());
        address.setState(request.getAddress().getState());
        address.setZipCode(request.getAddress().getZipCode());
        address.setFacility(facility);

        checkIfFacilityExists(request.getName());

        facility.setName(request.getName());
        facility.setPhone(request.getPhone());
        facility.setEmail(request.getEmail());
        facility.setContactPerson(request.getContactPerson());
        facility.setAddress(address);

        facilityRepository.save(facility);
        log.info(BusinessLogMessage.Facility.FACILITY_CREATED);
    }

    public void updateFacility(final String id, final UpdateFacilityRequest request) {
        Facility facility = findFacilityByFacilityId(id);
        Address address = facility.getAddress();

        address.setStreet(request.getAddress().getStreet());
        address.setCity(request.getAddress().getCity());
        address.setState(request.getAddress().getState());
        address.setZipCode(request.getAddress().getZipCode());
        address.setFacility(facility);

        if (!facility.getName().equals(request.getName())) {
            checkIfFacilityExists(request.getName());
        }

        facility.setName(request.getName());
        facility.setPhone(request.getName());
        facility.setEmail(request.getEmail());
        facility.setContactPerson(request.getContactPerson());
        facility.setAddress(address);

        facilityRepository.save(facility);
        log.info(BusinessLogMessage.Facility.FACILITY_UPDATED);
    }

    public void updateAddressInFacility(final String id, final UpdateAddressRequest request) {
        Facility facility = findFacilityByFacilityId(id);
        Address address = facility.getAddress();

        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setZipCode(request.getZipCode());

        facility.setAddress(address);

        facilityRepository.save(facility);
        log.info(BusinessLogMessage.Facility.FACILITY_UPDATED);
    }

    public void deleteFacility(final String id) {
        Facility facility = findFacilityByFacilityId(id);

        log.info(BusinessLogMessage.Facility.FACILITY_DELETED);
        facilityRepository.delete(facility);
    }

    public FacilityDto findFacilityById(final String id) {
        Facility facility = findFacilityByFacilityId(id);

        log.info(BusinessLogMessage.Facility.FACILITY_FIND);
        return converter.convert(facility);
    }

    public List<FacilityDto> findAllFacilities() {
        List<Facility> facilities = facilityRepository.findAll();

        if (facilities.isEmpty()) {
            log.error(BusinessLogMessage.Facility.FACILITY_LIST_EMPTY);
            throw new FacilityListEmptyException(BusinessMessage.Facility.FACILITY_LIST_EMPTY);
        }

        log.info(BusinessMessage.Facility.FACILITY_LISTED);
        return converter.convert(facilities);
    }

    private void checkIfFacilityExists(final String name) {
        if (facilityRepository.existsByNameIgnoreCase(name)) {
            log.error(BusinessLogMessage.Facility.FACILITY_ALREADY_EXISTS);
            throw new FacilityAlreadyExistException(BusinessMessage.Facility.FACILITY_ALREADY_EXISTS);
        }
    }

    protected Facility findFacilityByFacilityId(final String id) {
        return facilityRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Facility.FACILITY_NOT_FOUND);
            throw new FacilityNotFoundException(BusinessMessage.Facility.FACILITY_NOT_FOUND);
        });
    }
}
