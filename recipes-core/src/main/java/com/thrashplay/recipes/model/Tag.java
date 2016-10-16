package com.thrashplay.recipes.model;

/**
 * Model class representing a recipe tag
 *
 * @author Sean Kleinjung
 */
public class Tag {
    // the tag id
    private long id;

    // the name of this tag
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
