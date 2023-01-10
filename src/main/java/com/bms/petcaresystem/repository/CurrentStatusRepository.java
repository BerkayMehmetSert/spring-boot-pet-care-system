package com.bms.petcaresystem.repository;

import com.bms.petcaresystem.model.CurrentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentStatusRepository extends JpaRepository<CurrentStatus, String> {
}