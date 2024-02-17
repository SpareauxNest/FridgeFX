package com.example.fridgefx.model.controllers;

import com.example.fridgefx.model.Ingredient;
import com.example.fridgefx.model.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecipePageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label recipeTitle;

    @FXML
    private TreeView ingredientTree = new TreeView<>();

    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Recipe> recipes = new ArrayList<>();
    private Recipe recipe;

    public void SetUp(){
        TreeItem<String> rootItem = new TreeItem<>("Ingredients");
        ingredientTree.setRoot(rootItem);
        ingredients.stream().forEach(ingredient -> {
            if(Objects.nonNull(ingredient.getUnit())) {rootItem.getChildren().addAll(new TreeItem<>(ingredient.getQuantity()+" "+ingredient.getUnit()+" "+ingredient.getName()));}
            else {rootItem.getChildren().addAll(new TreeItem<>(ingredient.getQuantity()+" "+ingredient.getName()));}
        });

        recipeTitle.setText(recipe.getName());
    }

    public void SendRecipesToPage(List<Recipe> recipes, Recipe selectedRecipe) {
        this.recipes = recipes;
        this.recipe = selectedRecipe;
        this.ingredients = selectedRecipe.getIngredients();
    }

    public void ReturnToListView(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fridgefx/RecipeListView.fxml"));
            root = loader.load();
            ListViewController listViewController = loader.getController();
            listViewController.RecipeSubmit(recipes);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}