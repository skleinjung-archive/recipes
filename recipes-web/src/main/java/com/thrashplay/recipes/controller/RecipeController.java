package com.thrashplay.recipes.controller;

import com.thrashplay.recipes.model.Category;
import com.thrashplay.recipes.model.Ingredient;
import com.thrashplay.recipes.model.Instruction;
import com.thrashplay.recipes.model.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Add class documentation
 *
 * @author Sean Kleinjung
 */
@RestController()
@RequestMapping("/api/recipes")
public class RecipeController {

    private static List<Recipe> recipes = new ArrayList<Recipe>(2);
    static {
        Recipe recipe = new Recipe();
        recipe.setId(1);
        recipe.setName("Taco Lime Grilled Chicken");
        recipe.setCategory(Category.MainDish);
        recipe.setCookTime(10);
        recipe.setPrepTime(5);

        recipe.getIngredients().add(makeIngredient(1, "2", "tsp", "taco seasoning"));
        recipe.getIngredients().add(makeIngredient(2, "1/4", "cup", "lime juice"));
        recipe.getIngredients().add(makeIngredient(3, "1", "pound", "boneless and skinless chicken breasts"));

        recipe.getInstructions().add(makeInstruction(1, "Mix the taco seasoning and lime juice, cover the chicken in the mixture and optionally marinate for 30 minutes to over night."));
        recipe.getInstructions().add(makeInstruction(2, "Grill over medium-high heat until cooked through, about 3-5 minutes per side, let sit for 5 minutes and slice before enjoying!"));

        recipe.setSource("Closet Cooking");
        recipe.setSourceUrl("http://www.closetcooking.com/2015/09/taco-lime-grilled-chicken.html");

        recipes.add(recipe);
    }

    private static Ingredient makeIngredient(int id, String quantity, String units, String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(id);
        ingredient.setQuantity(quantity);
        ingredient.setUnit(units);
        ingredient.setName(name);
        return ingredient;
    }

    private static Instruction makeInstruction(int id, String text) {
        Instruction instruction = new Instruction();
        instruction.setId(id);
        instruction.setText(text);
        return instruction;
    }

    @GetMapping
    public List<Recipe> getAll() {
        return recipes;
    }

    @GetMapping("/{id}")
    public Recipe getById(@PathVariable int id) {
        return recipes.get(id - 1);
    }
}
