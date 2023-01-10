package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.SpeciesDto;
import com.bms.petcaresystem.dto.converter.SpeciesDtoConverter;
import com.bms.petcaresystem.exception.species.SpeciesListEmptyException;
import com.bms.petcaresystem.exception.species.SpeciesNotFoundException;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.Species;
import com.bms.petcaresystem.repository.SpeciesRepository;
import com.bms.petcaresystem.request.species.UpdateSpeciesRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SpeciesService {
    private final SpeciesRepository speciesRepository;
    private final SpeciesDtoConverter converter;

    public SpeciesService(SpeciesRepository speciesRepository,
                          SpeciesDtoConverter converter) {
        this.speciesRepository = speciesRepository;
        this.converter = converter;
    }

    public void updateSpecies(final String id, final UpdateSpeciesRequest request) {
        Species species = findSpeciesBySpeciesId(id);

        species.setName(request.getName());

        speciesRepository.save(species);
        log.info(BusinessLogMessage.Species.SPECIES_UPDATED);
    }

    public void deleteSpecies(final String id) {
        Species species = findSpeciesBySpeciesId(id);

        speciesRepository.delete(species);
        log.info(BusinessLogMessage.Species.SPECIES_DELETED);
    }

    public SpeciesDto findSpeciesById(final String id) {
        Species species = findSpeciesBySpeciesId(id);

        log.info(BusinessLogMessage.Species.SPECIES_FIND);
        return converter.convert(species);
    }

    public List<SpeciesDto> findAlSpecies() {
        List<Species> species = speciesRepository.findAll();

        if (species.isEmpty()) {
            log.error(BusinessLogMessage.Species.SPECIES_LIST_EMPTY);
            throw new SpeciesListEmptyException(BusinessMessage.Species.SPECIES_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Species.SPECIES_LIST);
        return converter.convert(species);
    }

    protected Species findSpeciesBySpeciesId(final String id) {
        return speciesRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Species.SPECIES_NOT_FOUND);
            throw new SpeciesNotFoundException(BusinessMessage.Species.SPECIES_NOT_FOUND);
        });
    }
}
