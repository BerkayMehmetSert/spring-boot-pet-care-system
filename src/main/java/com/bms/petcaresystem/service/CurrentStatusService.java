package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.CurrentStatusDto;
import com.bms.petcaresystem.dto.converter.CurrentStatusDtoConverter;
import com.bms.petcaresystem.exception.currentstatus.CurrentStatusListEmptyException;
import com.bms.petcaresystem.exception.currentstatus.CurrentStatusNotFoundException;
import com.bms.petcaresystem.helper.DateHelper;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.CurrentStatus;
import com.bms.petcaresystem.repository.CurrentStatusRepository;
import com.bms.petcaresystem.request.currentstatus.CreateCurrentStatusRequest;
import com.bms.petcaresystem.request.currentstatus.UpdateCurrentStatusRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CurrentStatusService {
    private final CurrentStatusRepository currentStatusRepository;
    private final PetCaseService petCaseService;
    private final StatusService statusService;
    private final CurrentStatusDtoConverter converter;

    public CurrentStatusService(CurrentStatusRepository currentStatusRepository,
                                PetCaseService petCaseService,
                                StatusService statusService,
                                CurrentStatusDtoConverter converter) {
        this.currentStatusRepository = currentStatusRepository;
        this.petCaseService = petCaseService;
        this.statusService = statusService;
        this.converter = converter;
    }

    public void createCurrentStatus(final CreateCurrentStatusRequest request) {
        CurrentStatus currentStatus = new CurrentStatus();

        currentStatus.setInsertTime(DateHelper.getCurrentDateTime());
        currentStatus.setNotes(request.getNotes());
        currentStatus.setPetCase(petCaseService.findPetCaseByPetCaseId(request.getPetCaseId()));
        currentStatus.setStatus(statusService.findStatusByStatusId(request.getStatusId()));

        currentStatusRepository.save(currentStatus);
        log.info(BusinessLogMessage.CurrentStatus.CURRENT_STATUS_CREATED);
    }

    public void updateCurrentStatus(final String id, final UpdateCurrentStatusRequest request) {
        CurrentStatus currentStatus = findCurrentStatusByCurrentStatusId(id);

        currentStatus.setNotes(request.getNotes());
        currentStatus.setPetCase(petCaseService.findPetCaseByPetCaseId(request.getPetCaseId()));
        currentStatus.setStatus(statusService.findStatusByStatusId(request.getStatusId()));

        currentStatusRepository.save(currentStatus);
        log.info(BusinessLogMessage.CurrentStatus.CURRENT_STATUS_UPDATED);
    }

    public void deleteCurrentStatus(final String id) {
        CurrentStatus currentStatus = findCurrentStatusByCurrentStatusId(id);

        currentStatusRepository.delete(currentStatus);
        log.info(BusinessLogMessage.CurrentStatus.CURRENT_STATUS_DELETED);
    }

    public CurrentStatusDto findCurrentStatusById(final String id) {
        CurrentStatus currentStatus = findCurrentStatusByCurrentStatusId(id);

        log.info(BusinessLogMessage.CurrentStatus.CURRENT_STATUS_FIND);
        return converter.convert(currentStatus);
    }

    public List<CurrentStatusDto> findAllCurrentStatuses() {
        List<CurrentStatus> currentStatuses = currentStatusRepository.findAll();

        if (currentStatuses.isEmpty()) {
            log.error(BusinessLogMessage.CurrentStatus.CURRENT_STATUS_LIST_EMPTY);
            throw new CurrentStatusListEmptyException(BusinessMessage.CurrentStatus.CURRENT_STATUS_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.CurrentStatus.CURRENT_STATUS_LIST);
        return converter.convert(currentStatuses);
    }

    protected CurrentStatus findCurrentStatusByCurrentStatusId(final String id) {
        return currentStatusRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.CurrentStatus.CURRENT_STATUS_NOT_FOUND);
            throw new CurrentStatusNotFoundException(BusinessMessage.CurrentStatus.CURRENT_STATUS_NOT_FOUND);
        });
    }
}
