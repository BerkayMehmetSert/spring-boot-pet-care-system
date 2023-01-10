package com.bms.petcaresystem.repository;

import com.bms.petcaresystem.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, String> {
}