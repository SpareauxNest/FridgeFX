package com.example.fridgefx.model;

public class Ingredient {
    private String name;

    private Double quantity;

    private String unit;

    public Ingredient(String name, double quantity, String unit){
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

    public static Ingredient build(String name, double quantity, String unit){
        return new Ingredient(name, quantity, unit);
    }
}
