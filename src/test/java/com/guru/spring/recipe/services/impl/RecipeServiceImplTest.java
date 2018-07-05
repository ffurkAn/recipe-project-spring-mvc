package com.guru.spring.recipe.services.impl;

import com.guru.spring.recipe.models.Recipe;
import com.guru.spring.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {

        Recipe r = new Recipe();
        r.setTitle("test recipe");

        List<Recipe> recipeSet = new ArrayList<>();
        recipeSet.add(r);

        // when getRecipes called, return recipeSet
        when(recipeService.getRecipes()).thenReturn(recipeSet);

        List<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);

        // verify that findAll method called only once
        verify(recipeRepository, times(1)).findAll();
    }
}