package com.bms.petcaresystem.repository;

import com.bms.petcaresystem.model.PetServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetServiceProviderRepository extends JpaRepository<PetServiceProvider, String> {
}