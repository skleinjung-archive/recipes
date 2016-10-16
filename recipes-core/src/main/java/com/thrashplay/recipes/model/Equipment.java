package com.thrashplay.recipes.model;

/**
 * Model class representing equipment needed to make a recipe.
 *
 * @author Sean Kleinjung
 */
public class Equipment {
    // the ingredient ID
    private long id;

    // the name of the ingredient
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
