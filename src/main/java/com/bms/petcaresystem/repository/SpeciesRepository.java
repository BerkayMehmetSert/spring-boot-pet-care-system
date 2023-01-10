package com.bms.petcaresystem.repository;

import com.bms.petcaresystem.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, String> {
}