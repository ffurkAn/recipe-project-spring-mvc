package com.guru.spring.recipe.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @Test
    public void getDescription() {

        String desc = "description";

        category.setDescription(desc);

        assertEquals(desc, category.getDescription());

    }

    @Test
    public void getRecipes() {
    }
}