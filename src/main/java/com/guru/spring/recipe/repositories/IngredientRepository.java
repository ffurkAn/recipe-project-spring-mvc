package com.guru.spring.recipe.repositories;

import com.guru.spring.recipe.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
