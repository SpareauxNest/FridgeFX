package com.example.fridgefx;

import com.example.fridgefx.model.controllers.AddRecipeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TreeViewController implements Initializable {

    @FXML
    TreeView treeView;

    @FXML
    Button newRecipeButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void AddNewRecipe(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddRecipe.fxml"));
            root = loader.load();
            AddRecipeController addRecipeController = loader.getController();
            //root = FXMLLoader.load(getClass().getResource("AddRecipe.fxml"));

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
