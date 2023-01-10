package com.bms.petcaresystem.repository;

import com.bms.petcaresystem.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, String> {
    boolean existsByNameIgnoreCase(String name);
}