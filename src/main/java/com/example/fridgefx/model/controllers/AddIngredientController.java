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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddIngredientController implements Initializable {

    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Recipe> recipes = new ArrayList<>();

    @FXML
    private ChoiceBox<String> unitBox;

    @FXML
    private Button ingredientButton;

    @FXML
    private TextField ingredientField;

    @FXML
    private TextField quantityField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String[] units = {"custom", "tsp", "tbs", "fl oz", "cup(s)", "pint(s)", "quart(s)", "lb", "oz", "mL", "L", "mg", "g", "kg"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitBox.getItems().addAll(units);
    }

    public void sendDataToIngredient(List<Recipe> recipes, List<Ingredient> ingredients){
        this.recipes = recipes;
        this.ingredients = ingredients;
    }

    public void submitIngredient(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fridgefx/AddRecipe.fxml"));
            root = loader.load();

            ingredients.add(new Ingredient(ingredientField.getText(), Double.valueOf(quantityField.getText()), unitBox.getValue()));
            AddRecipeController addRecipeController = loader.getController();
            addRecipeController.sendListToRecipeController(recipes, ingredients);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backToRecipe(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fridgefx/AddRecipe.fxml"));
            root = loader.load();
            AddRecipeController addRecipeController = loader.getController();
            addRecipeController.sendListToRecipeController(recipes, ingredients);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
