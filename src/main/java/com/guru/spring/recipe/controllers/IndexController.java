package com.guru.spring.recipe.controllers;

import com.guru.spring.recipe.models.Category;
import com.guru.spring.recipe.models.UnitOfMeasure;
import com.guru.spring.recipe.repositories.CategoryRepository;
import com.guru.spring.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){

        Optional<Category> c = categoryRepository.findByDescription("American");


        System.out.println("Category ID: " + c.get().getId());
        return "index";
    }
}
