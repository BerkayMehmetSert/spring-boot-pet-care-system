package com.bms.petcaresystem.repository;

import com.bms.petcaresystem.model.PetServicePlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetServicePlanRepository extends JpaRepository<PetServicePlan, String> {
}