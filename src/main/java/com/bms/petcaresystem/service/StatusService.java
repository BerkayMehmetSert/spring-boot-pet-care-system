package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.StatusDto;
import com.bms.petcaresystem.dto.converter.StatusDtoConverter;
import com.bms.petcaresystem.exception.status.StatusListEmptyException;
import com.bms.petcaresystem.exception.status.StatusNotFoundException;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.Status;
import com.bms.petcaresystem.repository.StatusRepository;
import com.bms.petcaresystem.request.status.CreateStatusRequest;
import com.bms.petcaresystem.request.status.UpdateStatusRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StatusService {
    private final StatusRepository statusRepository;
    private final StatusCategoryService statusCategoryService;
    private final StatusDtoConverter converter;

    public StatusService(StatusRepository statusRepository,
                         StatusCategoryService statusCategoryService,
                         StatusDtoConverter converter) {
        this.statusRepository = statusRepository;
        this.statusCategoryService = statusCategoryService;
        this.converter = converter;
    }

    public void createStatus(final CreateStatusRequest request) {
        Status status = new Status();

        checkIfStatusExist(request.getName());

        status.setName(request.getName());
        status.setStatusCategory(statusCategoryService
                .findStatusCategoryByStatusCategoryId(request.getStatusCategoryId()));
        status.setIsActive(true);

        statusRepository.save(status);
        log.info(BusinessLogMessage.Status.STATUS_CREATED);
    }

    public void updateStatus(final String id, final UpdateStatusRequest request) {
        Status status = findStatusByStatusId(id);

        if (!status.getName().equals(request.getName())) {
            checkIfStatusExist(request.getName());
        }

        status.setName(request.getName());
        status.setStatusCategory(statusCategoryService
                .findStatusCategoryByStatusCategoryId(request.getStatusCategoryId()));

        statusRepository.save(status);
        log.info(BusinessLogMessage.Status.STATUS_UPDATED);
    }

    public void updateStatusCategoryInStatus(final String id, final String categoryId) {
        Status status = findStatusByStatusId(id);

        status.setStatusCategory(statusCategoryService.findStatusCategoryByStatusCategoryId(categoryId));

        statusRepository.save(status);
        log.info(BusinessLogMessage.Status.STATUS_UPDATED);
    }

    public void deleteStatus(final String id) {
        Status status = findStatusByStatusId(id);

        status.setIsActive(false);

        statusRepository.save(status);
        log.info(BusinessLogMessage.Status.STATUS_DELETED);
    }

    public StatusDto findStatusById(final String id) {
        Status status = findStatusByStatusId(id);

        log.info(BusinessLogMessage.Status.STATUS_FIND);
        return converter.convert(status);
    }

    public List<StatusDto> findAllStatus(){
        List<Status> statuses = statusRepository.findAll();

        if (statuses.isEmpty()) {
            log.error(BusinessLogMessage.Status.STATUS_LIST_EMPTY);
            throw new StatusListEmptyException(BusinessMessage.Status.STATUS_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Status.STATUS_FIND);
        return converter.convert(statuses);
    }

    protected Status findStatusByStatusId(String id) {
        return statusRepository.findById(id)
                .filter(status -> status.getIsActive().equals(true))
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.Status.STATUS_NOT_FOUND);
                    throw new StatusNotFoundException(BusinessMessage.Status.STATUS_NOT_FOUND);
                });
    }

    private void checkIfStatusExist(final String name) {
        if (statusRepository.existsByNameIgnoreCase(name)) {
            log.error(BusinessLogMessage.Status.STATUS_ALREADY_EXISTS);
            throw new StatusNotFoundException(BusinessMessage.Status.STATUS_ALREADY_EXISTS);
        }
    }
}
