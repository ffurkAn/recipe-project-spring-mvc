package com.guru.spring.recipe.repositories;

import com.guru.spring.recipe.models.Notes;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Notes, Long> {
}
