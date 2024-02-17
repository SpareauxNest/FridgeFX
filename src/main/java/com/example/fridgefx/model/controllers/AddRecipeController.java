package com.example.fridgefx.model.controllers;

import com.example.fridgefx.model.Ingredient;
import com.example.fridgefx.model.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddRecipeController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Recipe> recipes = new ArrayList<>();

    @FXML
    private TextField recipeNameField;

    @FXML
    private TextField recipeLinkField;

    @FXML
    private ListView ingredientListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ingredients.stream().forEach(ingredient -> {
            ingredientListView.getItems().add(ingredient.getName());
        });
        ingredientListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void sendListToRecipeController(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public void sendListToRecipeController(List<Recipe> recipes, List<Ingredient> ingredients) {
        this.recipes = recipes;
        this.ingredients = ingredients;
        ingredients.stream().forEach(ingredient -> {
            ingredientListView.getItems().add(ingredient.getName());
        });
    }

    public void AddNewIngredient(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fridgefx/AddIngredient.fxml"));
            root = loader.load();
            AddIngredientController addIngredientController = loader.getController();
            addIngredientController.sendDataToIngredient(recipes, ingredients);

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
