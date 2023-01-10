package com.bms.petcaresystem.repository;

import com.bms.petcaresystem.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, String> {
    boolean existsByNameIgnoreCase(String name);
}