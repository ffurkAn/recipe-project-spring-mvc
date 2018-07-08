package com.guru.spring.recipe.controllers;

import com.guru.spring.recipe.models.Recipe;
import com.guru.spring.recipe.services.RecipeService;
import com.guru.spring.recipe.services.impl.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import sun.reflect.generics.visitor.Reifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        // given
        List<Recipe> recipeList = new ArrayList<>();

        Recipe recipe= new Recipe();
        recipe.setTitle("test1");

        Recipe recipe1 = new Recipe();
        recipe1.setTitle("test2");

        recipeList.add(recipe);
        recipeList.add(recipe1);

        when(recipeService.getRecipes()).thenReturn(recipeList);

        ArgumentCaptor<List<Recipe>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        // when
        String str = indexController.getRecipes(model);

        // then
        assertEquals("recipes", str);

        // TODO verify proper string is returned
        // ??

        // TODO verify intereactions with mocks
        verify(recipeService, times(1)).getRecipes(); // correct
        verify(model,times(1)).addAttribute(eq("recipes"), argumentCaptor.capture()); // cuz we did not verify recipe list, we use argument capture
        List<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}