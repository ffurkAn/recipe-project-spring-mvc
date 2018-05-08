package com.guru.spring.recipe.controllers;

import com.guru.spring.recipe.models.Category;
import com.guru.spring.recipe.models.Recipe;
import com.guru.spring.recipe.models.UnitOfMeasure;
import com.guru.spring.recipe.repositories.CategoryRepository;
import com.guru.spring.recipe.repositories.UnitOfMeasureRepository;
import com.guru.spring.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeService recipeService;


    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> c = categoryRepository.findByDescription("American");


        System.out.println("Category ID: " + c.get().getId());
        return "index";
    }

    @RequestMapping({"/recipes"})
    public String getRecipes(Model model) {

        List<Recipe> recipeList = recipeService.getRecipes();
        model.addAttribute("recipes", recipeList);

        return "recipes";
    }
}
