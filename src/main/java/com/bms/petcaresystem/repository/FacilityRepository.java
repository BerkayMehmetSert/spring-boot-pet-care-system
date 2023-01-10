package com.bms.petcaresystem.repository;

import com.bms.petcaresystem.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, String> {
    boolean existsByNameIgnoreCase(String name);
}