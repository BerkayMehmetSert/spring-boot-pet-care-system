package com.bms.petcaresystem.repository;

import com.bms.petcaresystem.model.PetCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetCaseRepository extends JpaRepository<PetCase, String> {
}