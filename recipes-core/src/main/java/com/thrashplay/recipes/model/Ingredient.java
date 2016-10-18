package com.thrashplay.recipes.model;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Model class representing a recipe ingredient.
 *
 * @author Sean Kleinjung
 */
public class Ingredient {
    // the ingredient ID
    private long id;

    // the quantity of this ingredient needed
    @NotBlank
    private String quantity;

    // the units to use when interpreting the quantity
    @NotBlank
    private String units;

    // the name of the ingredient
    @NotBlank
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

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", quantity='" + quantity + '\'' +
                ", units='" + units + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
