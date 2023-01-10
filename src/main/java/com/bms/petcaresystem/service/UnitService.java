package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.UnitDto;
import com.bms.petcaresystem.dto.converter.UnitDtoConverter;
import com.bms.petcaresystem.exception.unit.UnitAlreadyExistException;
import com.bms.petcaresystem.exception.unit.UnitListEmptyException;
import com.bms.petcaresystem.exception.unit.UnitNotFoundException;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.Unit;
import com.bms.petcaresystem.repository.UnitRepository;
import com.bms.petcaresystem.request.unit.CreateUnitRequest;
import com.bms.petcaresystem.request.unit.UpdateUnitRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UnitService {
    private final UnitRepository unitRepository;
    private final UnitDtoConverter converter;

    public UnitService(UnitRepository unitRepository,
                       UnitDtoConverter converter) {
        this.unitRepository = unitRepository;
        this.converter = converter;
    }

    public void createUnit(final CreateUnitRequest request) {
        Unit unit = new Unit();

        checkIfUnitExist(request.getName());

        unit.setName(request.getName());

        unitRepository.save(unit);
        log.info(BusinessLogMessage.Unit.UNIT_CREATED);
    }


    public void updateUnit(final String id, final UpdateUnitRequest request) {
        Unit unit = findUnitByUnitId(id);

        if (!unit.getName().equals(request.getName())) {
            checkIfUnitExist(request.getName());
        }

        unit.setName(request.getName());

        unitRepository.save(unit);
        log.info(BusinessLogMessage.Unit.UNIT_UPDATED);
    }

    public void deleteUnit(final String id) {
        Unit unit = findUnitByUnitId(id);

        log.error(BusinessLogMessage.Unit.UNIT_DELETED);
        unitRepository.delete(unit);
    }

    public UnitDto findUnitById(final String id) {
        Unit unit = findUnitByUnitId(id);

        log.info(BusinessLogMessage.Unit.UNIT_FIND);
        return converter.convert(unit);
    }

    public List<UnitDto> findAllUnits() {
        List<Unit> units = unitRepository.findAll();

        if (units.isEmpty()) {
            log.error(BusinessLogMessage.Unit.UNIT_LIST_EMPTY);
            throw new UnitListEmptyException(BusinessMessage.Unit.UNIT_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Unit.UNIT_LIST);
        return converter.convert(units);
    }

    protected Unit findUnitByUnitId(final String id) {
        return unitRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.Unit.UNIT_NOT_FOUND);
                    throw new UnitNotFoundException(BusinessMessage.Unit.UNIT_NOT_FOUND);
                });
    }

    private void checkIfUnitExist(final String name) {
        if (unitRepository.existsByNameIgnoreCase(name)) {
            log.error(BusinessLogMessage.Unit.UNIT_ALREADY_EXISTS);
            throw new UnitAlreadyExistException(BusinessMessage.Unit.UNIT_ALREADY_EXISTS);
        }
    }
}
