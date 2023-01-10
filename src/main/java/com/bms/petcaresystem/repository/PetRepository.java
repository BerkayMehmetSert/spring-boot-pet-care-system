package com.bms.petcaresystem.repository;

import com.bms.petcaresystem.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, String> {
}