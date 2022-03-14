package com.notes.repository;

import com.notes.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes,Integer> {
}
