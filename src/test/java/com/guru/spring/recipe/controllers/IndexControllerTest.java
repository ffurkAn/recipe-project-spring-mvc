package com.guru.spring.recipe.controllers;

import com.guru.spring.recipe.models.Recipe;
import com.guru.spring.recipe.services.RecipeService;
import com.guru.spring.recipe.services.impl.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        indexController = new IndexController(recipeService);

    }

    @Test
    public void getRecipes() {

        String str = indexController.getRecipes(model);

        assertEquals("recipes", str);
        // TODO verify proper string is returned
        // ??


        // TODO verify intereactions with mocks
        verify(recipeService, times(1)).getRecipes(); // correct
        verify(model,times(1)).addAttribute(eq("recipes"), anyList()); // from review
    }
}