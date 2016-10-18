package com.thrashplay.recipes.model;

import com.github.slugify.Slugify;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

/**
 * Model class representing a recipe.
 *
 * @author Sean Kleinjung
 */
public class Recipe {
    private static final Slugify slugify = new Slugify();

    // the recipe ID
    private long id;

    // the name of the recipe
    @NotBlank
    private String name;

    // the description of this recipe
    @NotBlank
    private String description;

    // the category of recipe
    @NotNull
    private Category category;

    // tags associated with this recipe
    private List<Tag> tags = new LinkedList<Tag>();

    // the prep time, in minutes
    @Min(0)
    private int prepTime;

    // the cook time, in minutes
    @Min(0)
    private int cookTime;

    // ingredients
    @Valid
    private List<Ingredient> ingredients = new LinkedList<Ingredient>();

    // equipment
    @Valid
    private List<Equipment> equipment = new LinkedList<Equipment>();

    // instructions
    @Valid
    private List<Instruction> instructions = new LinkedList<Instruction>();

    // the source of this recipe
    private String source;

    // the URL of the recipe source, if one exists\
    private String sourceUrl;

    // main image

    // other images

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSlug() {
        return slugify.slugify(getName());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", tags=" + tags +
                ", prepTime=" + prepTime +
                ", cookTime=" + cookTime +
                ", ingredients=" + ingredients +
                ", equipment=" + equipment +
                ", instructions=" + instructions +
                ", source='" + source + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                '}';
    }
}
