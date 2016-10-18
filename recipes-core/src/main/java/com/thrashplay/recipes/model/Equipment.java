package com.thrashplay.recipes.model;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Model class representing equipment needed to make a recipe.
 *
 * @author Sean Kleinjung
 */
public class Equipment {
    // the ingredient ID
    private long id;

    // the description of the equipment
    @NotBlank
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
