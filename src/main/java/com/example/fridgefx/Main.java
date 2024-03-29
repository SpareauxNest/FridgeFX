package com.example.fridgefx;

import com.example.fridgefx.model.Ingredient;
import com.example.fridgefx.model.Recipe;
import com.example.fridgefx.model.controllers.ListViewController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application{
    Stage window;

    Grids grids = new Grids();
    private List<Recipe> recipes = new ArrayList<>();

    Button enterButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Garlic", 1, "clove"));
        ingredients.add(new Ingredient("Butter", 2, "tbs"));

        recipes.add(new Recipe("Garlic Butter", ingredients, "italian.com"));
        recipes.add(new Recipe("Buttered Garlic", ingredients, "badbreath.net"));

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fridgefx/RecipeListView.fxml"));
            Parent root = loader.load();
            ListViewController listViewController = loader.getController();
            listViewController.RecipeSubmit(recipes);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}