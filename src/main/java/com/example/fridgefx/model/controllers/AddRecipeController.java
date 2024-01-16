package com.example.fridgefx.model.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddRecipeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void AddNewIngredient(ActionEvent event) {
        //untested copy paste
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddIngredient.fxml"));
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

}
