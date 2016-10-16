package com.thrashplay.recipes.model;

/**
 * Model class representing a recipe ingredient.
 *
 * @author Sean Kleinjung
 */
public class Ingredient {
    // the ingredient ID
    private long id;

    // the quantity of this ingredient needed
    private String quantity;

    // the unit to use when interpreting the quantity
    private String unit;

    // the name of the ingredient
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
