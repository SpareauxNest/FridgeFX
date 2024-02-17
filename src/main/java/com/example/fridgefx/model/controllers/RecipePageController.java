package com.example.fridgefx.model.controllers;

import com.example.fridgefx.model.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RecipePageController implements Initializable {

    @FXML
    private TextField recipeTitle;

    @FXML
    private TreeView treeView;

    private List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> header = new TreeItem<>("Ingredients");
        ingredients.stream().forEach(ingredient -> {
            header.getChildren().addAll(new TreeItem<>(ingredient.getQuantity()+" "+ingredient.getUnit()+" "+ingredient.getName()));
        });
        treeView.setRoot(header);
    }
}