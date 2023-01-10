package com.bms.petcaresystem.repository;

import com.bms.petcaresystem.model.StatusCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusCategoryRepository extends JpaRepository<StatusCategory, String> {
    boolean existsByNameIgnoreCase(String name);
}