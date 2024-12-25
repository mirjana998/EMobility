module com.example.epj2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.epj2 to javafx.fxml;
    exports com.example.epj2.controller;
    opens com.example.epj2.controller to javafx.fxml;
    opens com.example.epj2.model.electricvehicle to javafx.base;
    opens com.example.epj2.model.rent to javafx.base;
    exports com.example.epj2;
    exports com.example.epj2.model.rent;
    exports com.example.epj2.model.map;
    exports com.example.epj2.model.electricvehicle;
}