package com.example.fridgefx.model.controllers;

import com.example.fridgefx.model.Ingredient;
import com.example.fridgefx.model.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class AddRecipeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private List<Ingredient> ingredients;
    private List<Recipe> recipes;

    @FXML
    private TextField recipeNameField;

    @FXML
    private TextField recipeLinkField;

    public void sendListToRecipeController(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void AddNewIngredient(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fridgefx/AddIngredient.fxml"));
            root = loader.load();
            AddIngredientController addIngredientController = loader.getController();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backToList(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fridgefx/RecipeListView.fxml"));
            root = loader.load();
            ListViewController listViewController = loader.getController();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submitRecipe(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fridgefx/RecipeListView.fxml"));
            root = loader.load();
            ListViewController listViewController = loader.getController();

            recipes.add(new Recipe(recipeNameField.getText() , ingredients, recipeLinkField.getText()));

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
