    package com.guru.spring.recipe.bootstrap;

    import com.guru.spring.recipe.enums.Difficulty;
    import com.guru.spring.recipe.models.*;
    import com.guru.spring.recipe.repositories.*;
    import org.springframework.context.ApplicationListener;
    import org.springframework.context.event.ContextRefreshedEvent;
    import org.springframework.stereotype.Component;

    import java.math.BigDecimal;

    @Component
    public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

        private RecipeRepository recipeRepository;
        private CategoryRepository categoryRepository;
        private UnitOfMeasureRepository unitOfMeasureRepository;

        public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, IngredientRepository ingredientRepository, NotesRepository notesRepository) {
            this.recipeRepository = recipeRepository;
            this.categoryRepository = categoryRepository;
            this.unitOfMeasureRepository = unitOfMeasureRepository;
        }

        @Override
        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            generateRecipe();
        }

        private void generateRecipe() {
            Recipe r = new Recipe();
            r.setTitle("How to Make Perfect Guocamole!");
            r.setPrepTime(10);


            Notes notes = new Notes();
            notes.setRecipe(r);
            notes.setRecipeNotes("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                    "\n" +
                    "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                    "\n" +
                    "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                    "\n" +
                    "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                    "\n" +
                    "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                    "\n" +
                    "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                    "\n" +
                    "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                    "\n" +
                    "Variations\n" +
                    "\n" +
                    "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                    "\n" +
                    "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                    "\n" +
                    "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                    "\n" +
                    "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                    "\n" +
                    "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");

            r.setNotes(notes);

            Category dip = new Category();
            dip.setDescription("dip");
            categoryRepository.save(dip);
            r.getCategories().add(dip);

            Category mexican = new Category();
            mexican.setDescription("Mexican");
            categoryRepository.save(mexican);
            r.getCategories().add(mexican);

            Category vegan = new Category();
            vegan.setDescription("vegan");
            categoryRepository.save(vegan);
            r.getCategories().add(vegan);

            Category avocado = new Category();
            avocado.setDescription("avocado");
            categoryRepository.save(avocado);
            r.getCategories().add(avocado);

            r.setDescription("The BEST guacamole! So easy to make with ripe avocados, salt, serrano chiles, cilantro and lime. Garnish with red radishes or jicama. Serve with tortilla chips. Watch how to make guacamole - it's easy!");
            r.setCookTime(null);
            r.setDifficulty(Difficulty.EASY);

            UnitOfMeasure teaspoon = new UnitOfMeasure();
            teaspoon.setUom("teaspoon");
            unitOfMeasureRepository.save(teaspoon);

            UnitOfMeasure tbsp = new UnitOfMeasure();
            tbsp.setUom("Tbsp");
            unitOfMeasureRepository.save(tbsp);

            UnitOfMeasure cup = new UnitOfMeasure();
            cup.setUom("cup");
            unitOfMeasureRepository.save(cup);

            Ingredient i1 = new Ingredient();
            i1.setAmount(new BigDecimal(2));
            i1.setDescription("ripe avocados");
            i1.setRecipe(r);
            r.getIngredients().add(i1);

            Ingredient i2 = new Ingredient();
            i2.setAmount(BigDecimal.valueOf(0.5));
            i2.setDescription("Kosher salt");
            i2.setUom(teaspoon);
            i2.setRecipe(r);
            r.getIngredients().add(i2);

            Ingredient i3 = new Ingredient();
            i3.setAmount(BigDecimal.ONE);
            i3.setDescription("of fresh lime juice or lemon juice");
            i3.setUom(tbsp);
            i3.setRecipe(r);
            r.getIngredients().add(i3);

            Ingredient i4 = new Ingredient();
            i4.setAmount(new BigDecimal(2));
            i4.setDescription("of minced red onion ır thinly sliced green onion");
            i4.setUom(tbsp);
            i4.setRecipe(r);
            r.getIngredients().add(i4);

            Ingredient i5 = new Ingredient();
            i5.setAmount(new BigDecimal(1));
            i5.setDescription("serrano chiles, stems and seeds removed, minced");
            i5.setRecipe(r);
            r.getIngredients().add(i5);

            Ingredient i6 = new Ingredient();
            i6.setAmount(new BigDecimal(2));
            i6.setDescription("cilantro ( leaves and tender stems), finely chopped");
            i6.setUom(teaspoon);
            i6.setRecipe(r);
            r.getIngredients().add(i6);

            Ingredient i7 = new Ingredient();
            i7.setDescription("a dash of freshly grated black pepper");
            i7.setRecipe(r);
            r.getIngredients().add(i7);

            Ingredient i8 = new Ingredient();
            i8.setAmount(BigDecimal.valueOf(0.5));
            i8.setDescription("ripe tomato, seeds and pulp removed, chopped");
            i8.setRecipe(r);
            r.getIngredients().add(i8);

            r.setDirection("2 ripe avocados\n" +
                    "1/2 teaspoon Kosher salt\n" +
                    "1 Tbsp of fresh lime juice or lemon juice\n" +
                    "2 Tbsp to 1/4 cup of minced red onion or thinly sliced green onion\n" +
                    "1-2 serrano chiles, stems and seeds removed, minced\n" +
                    "2 tablespoons cilantro (leaves and tender stems), finely chopped\n" +
                    "A dash of freshly grated black pepper\n" +
                    "1/2 ripe tomato, seeds and pulp removed, chopped");
            recipeRepository.save(r);

        }
    }
