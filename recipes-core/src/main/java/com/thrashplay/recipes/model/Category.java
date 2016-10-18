package com.thrashplay.recipes.model;


import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Model enumeration defining what category a recipe belongs to.
 *
 * @author Sean Kleinjung
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Category {
    Appetizer(0, "Appetizer"),
    MainDish(1, "Main Dish"),
    Dessert(2, "Dessert");

    private long id;
    private String name;

    private Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Category fromId(long id) {
        for (Category category : Category.values()) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}
