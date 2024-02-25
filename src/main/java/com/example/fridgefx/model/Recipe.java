package com.example.fridgefx.model;

import java.util.List;
import java.util.UUID;

public class Recipe {

    private String id;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private String name;

    private List<Ingredient> ingredients;

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getLink() {return link;}
    private String link;

    public Recipe(String name, List<Ingredient> ingredients, String link) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.ingredients = ingredients;
        this.link = link;
    }

    public static Recipe build(String name, List<Ingredient> ingredients, String link){
        return new Recipe(name, ingredients, link);
    }
}