package com.guru.spring.recipe.bootstrap;

import com.guru.spring.recipe.models.Ingredient;
import com.guru.spring.recipe.models.Recipe;
import com.guru.spring.recipe.models.UnitOfMeasure;
import com.guru.spring.recipe.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private IngredientRepository ingredientRepository;
    private NotesRepository notesRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, IngredientRepository ingredientRepository, NotesRepository notesRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.ingredientRepository = ingredientRepository;
        this.notesRepository = notesRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        generateRecipe();
    }

    private void generateRecipe() {
        Recipe r = new Recipe();

    }
}
