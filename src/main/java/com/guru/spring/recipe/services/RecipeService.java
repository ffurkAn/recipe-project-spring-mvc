package com.guru.spring.recipe.services;

import com.guru.spring.recipe.models.Recipe;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface RecipeService {

    List<Recipe> getRecipes();
}
