package com.example.fridgefx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ChoiceBox<String> unitBox;

    private String[] units = {"custom", "tsp", "tbs", "fl oz", "cup(s)", "pint(s)", "quart(s)", "lb", "oz", "mL", "L", "mg", "g", "kg"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitBox.getItems().addAll(units);
    }
}
