package com.thrashplay.recipes.controller;

import com.thrashplay.recipes.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that returns Recipes reference data.
 *
 * @author Sean Kleinjung
 */
@RestController()
@RequestMapping("/api")
public class ReferenceDataController {
    @GetMapping("/categories")
    public Category[] getCategories() {
        return Category.values();
    }
}
