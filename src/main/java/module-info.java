module com.example.fridgefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.fridgefx to javafx.fxml;
    exports com.example.fridgefx;
    exports com.example.fridgefx.model.controllers;
    opens com.example.fridgefx.model.controllers to javafx.fxml;
}