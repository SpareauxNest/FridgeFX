package com.example.fridgefx;

import com.example.fridgefx.model.Ingredient;
import com.example.fridgefx.model.Recipe;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

public class Main extends Application implements EventHandler<ActionEvent> {
    Stage window;

    Grids grids = new Grids();
    private List<Recipe> recipes = new ArrayList<>();

    Button enterButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        recipes.add(new Recipe("recipe1", new ArrayList<>(), ".com"));
        recipes.add(new Recipe("recipe2", new ArrayList<>(), ".net"));

        //grids.testing(primaryStage);
        //grids.listViewGrid(primaryStage, recipes);
        grids.addItemGrid(primaryStage, recipes);
    }

    @Override
    public void handle(ActionEvent event){
//        if (event.getSource() == enterButton) {
//            System.out.println("Bush did 9/11");
//        }
    }
}