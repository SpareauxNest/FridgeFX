package com.example.fridgefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ChoiceBox<String> unitBox;

    @FXML
    private Button ingredientButton;

    @FXML
    private TextField ingredientField;

    @FXML
    private TextField quantityField;

    private String[] units = {"custom", "tsp", "tbs", "fl oz", "cup(s)", "pint(s)", "quart(s)", "lb", "oz", "mL", "L", "mg", "g", "kg"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitBox.getItems().addAll(units);
    }

    public void submitIngredient(ActionEvent event) {

    }
}
