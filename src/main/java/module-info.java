module com.example.fridgefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fridgefx to javafx.fxml;
    exports com.example.fridgefx;
}