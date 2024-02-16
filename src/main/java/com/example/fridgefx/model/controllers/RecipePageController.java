package com.example.fridgefx.model.controllers;

import com.example.fridgefx.model.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RecipePageController implements Initializable {

    @FXML
    private TextField recipeTitle;

    @FXML
    private TreeView treeView;

    private List<Ingredient> ingredients;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}