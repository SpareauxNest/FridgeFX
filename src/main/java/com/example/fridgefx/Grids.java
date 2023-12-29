package com.example.fridgefx;


import com.example.fridgefx.model.Ingredient;
import com.example.fridgefx.model.Recipe;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Grids {
    Stage window;

    public void addItemGrid(Stage primaryStage, List<Recipe> recipes) {
        window = primaryStage;
        window.setTitle("FridgeFX");

        Button enterButton;

        GridPane addGrid = new GridPane();
        addGrid.setPadding(new Insets(10, 10, 10, 10));

        addGrid.setVgap(8);
        addGrid.setHgap(10);

        Label recipeLabel = new Label("Recipe:");
        GridPane.setConstraints(recipeLabel, 0, 0);

        TextField recipeInput = new TextField();
        GridPane.setConstraints(recipeInput, 1, 0);

        Label ingredientLabel = new Label("Ingredient:");
        GridPane.setConstraints(ingredientLabel, 0, 1);

        TextField ingredientInput = new TextField();
        GridPane.setConstraints(ingredientInput, 1, 1);

        enterButton = new Button("Add Recipe");
        enterButton.setOnAction( e -> {
            Ingredient ingredient = new Ingredient(ingredientInput.getText(), 2, "unit");
            List<Ingredient> ingredients= new ArrayList<>();
            ingredients.add(ingredient);
            recipes.add(new Recipe(recipeInput.getText(), ingredients, ""));
            System.out.println("Added item: ");
            System.out.println(recipes.get(recipes.size()-1).getName());
            listViewGrid(primaryStage, recipes);
        });
        GridPane.setConstraints(enterButton, 1, 2);

        addGrid.getChildren().addAll(recipeLabel, recipeInput, ingredientLabel, ingredientInput, enterButton);

        window.setScene(new Scene(addGrid));
        window.show();
    }
    public void listViewGrid(Stage primaryStage, List<Recipe> recipes){

        ListView<String> listView = new ListView<>();

        listView.getItems().addAll(recipes.stream().map(Recipe::getName).collect(Collectors.toList()));

        Button addButton = new Button("Add");
        addButton.setOnAction( e -> {
            addItemGrid(primaryStage, recipes);
        });

        BorderPane root = new BorderPane();

        root.setCenter(listView);
        root.setBottom(addButton);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void testing(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AddIngredient.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}