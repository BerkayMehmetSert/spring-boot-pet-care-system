package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.StatusCategoryDto;
import com.bms.petcaresystem.dto.converter.StatusCategoryDtoConverter;
import com.bms.petcaresystem.exception.statuscategory.StatusCategoryAlreadyExistException;
import com.bms.petcaresystem.exception.statuscategory.StatusCategoryListEmptyException;
import com.bms.petcaresystem.exception.statuscategory.StatusCategoryNotFoundException;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.StatusCategory;
import com.bms.petcaresystem.repository.StatusCategoryRepository;
import com.bms.petcaresystem.repository.StatusRepository;
import com.bms.petcaresystem.request.statuscategory.CreateStatusCategoryRequest;
import com.bms.petcaresystem.request.statuscategory.UpdateStatusCategoryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StatusCategoryService {
    private final StatusCategoryRepository statusCategoryRepository;
    private final StatusCategoryDtoConverter converter;

    public StatusCategoryService(StatusCategoryRepository statusCategoryRepository,
                                 StatusCategoryDtoConverter converter) {
        this.statusCategoryRepository = statusCategoryRepository;
        this.converter = converter;
    }

    public void createStatusCategory(final CreateStatusCategoryRequest request) {
        StatusCategory statusCategory = new StatusCategory();

        checkIfStatusCategoryExist(request.getName());

        statusCategory.setName(request.getName());

        statusCategoryRepository.save(statusCategory);
        log.info(BusinessLogMessage.StatusCategory.STATUS_CATEGORY_CREATED);
    }

    public void updateStatusCategory(final String id, final UpdateStatusCategoryRequest request) {
        StatusCategory statusCategory = findStatusCategoryByStatusCategoryId(id);

        if (!statusCategory.getName().equals(request.getName())) {
            checkIfStatusCategoryExist(request.getName());
        }

        statusCategory.setName(request.getName());

        log.info(BusinessLogMessage.StatusCategory.STATUS_CATEGORY_UPDATED);
    }

    public void deleteStatusCategory(final String id) {
        StatusCategory statusCategory = findStatusCategoryByStatusCategoryId(id);

        statusCategoryRepository.delete(statusCategory);
        log.info(BusinessLogMessage.StatusCategory.STATUS_CATEGORY_DELETED);
    }

    public StatusCategoryDto findStatusCategoryById(final String id) {
        StatusCategory statusCategory = findStatusCategoryByStatusCategoryId(id);

        log.info(BusinessLogMessage.StatusCategory.STATUS_CATEGORY_FIND);
        return converter.convert(statusCategory);
    }

    public List<StatusCategoryDto> findAllStatusCategories() {
        List<StatusCategory> statusCategories = statusCategoryRepository.findAll();

        if (statusCategories.isEmpty()) {
            log.error(BusinessLogMessage.StatusCategory.STATUS_CATEGORY_LIST_EMPTY);
            throw new StatusCategoryListEmptyException(BusinessMessage.StatusCategory.STATUS_CATEGORY_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.StatusCategory.STATUS_CATEGORY_LISTED);
        return converter.convert(statusCategories);
    }

    protected StatusCategory findStatusCategoryByStatusCategoryId(final String id) {
        return statusCategoryRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.StatusCategory.STATUS_CATEGORY_NOT_FOUND);
            throw new StatusCategoryNotFoundException(BusinessMessage
                    .StatusCategory.STATUS_CATEGORY_NOT_FOUND);
        });
    }

    private void checkIfStatusCategoryExist(final String name) {
        if (statusCategoryRepository.existsByNameIgnoreCase(name)) {
            log.error(BusinessLogMessage.StatusCategory.STATUS_CATEGORY_ALREADY_EXISTS);
            throw new StatusCategoryAlreadyExistException(BusinessMessage
                    .StatusCategory.STATUS_CATEGORY_ALREADY_EXISTS);
        }
    }
}
