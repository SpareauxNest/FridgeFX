package com.example.fridgefx.model.controllers;

import com.example.fridgefx.model.Ingredient;
import com.example.fridgefx.model.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RecipePageController implements Initializable {

    @FXML
    private Label recipeTitle;

    @FXML
    private TreeView treeView = new TreeView<>();

    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Recipe> recipes = new ArrayList<>();
    private Recipe recipe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> rootItem = new TreeItem<>("Ingredients");
        treeView.setRoot(rootItem);
        ingredients.stream().forEach(ingredient -> {
            rootItem.getChildren().addAll(new TreeItem<>(ingredient.getQuantity()+" "+ingredient.getUnit()+" "+ingredient.getName()));
        });

        recipeTitle.setText(recipe.getName());
    }

    public void sendRecipesToPage(List<Recipe> recipes, Recipe selectedRecipe) {
        this.recipes = recipes;
        this.recipe = selectedRecipe;
        this.ingredients = selectedRecipe.getIngredients();
    }
}