package com.example.fridgefx.model.controllers;

import com.example.fridgefx.model.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListViewController implements Initializable {

    @FXML
    ListView<String> listView = new ListView<>();

    @FXML
    Button newRecipeButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private List<Recipe> recipes = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recipes.stream().forEach(recipe -> {
            listView.getItems().add(recipe.getName());
        });
        //listView.getItems().add(recipes.stream().map(Recipe::getName).toString());
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void AddNewRecipe(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fridgefx/AddRecipe.fxml"));
            root = loader.load();
            AddRecipeController addRecipeController = loader.getController();

            addRecipeController.sendListToRecipeController(recipes);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void RecipeSubmit(List<Recipe> recipes){
        this.recipes = recipes;
        recipes.stream().forEach(recipe -> {
            listView.getItems().add(recipe.getName());
        });
    }

}
