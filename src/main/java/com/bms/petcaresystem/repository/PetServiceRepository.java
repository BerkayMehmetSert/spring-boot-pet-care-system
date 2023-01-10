package com.bms.petcaresystem.repository;

import com.bms.petcaresystem.model.PetService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetServiceRepository extends JpaRepository<PetService, String> {
    boolean existsByNameIgnoreCase(String name);
}