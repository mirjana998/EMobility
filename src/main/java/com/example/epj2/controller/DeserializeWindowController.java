package com.example.epj2.controller;

import com.example.epj2.model.Configuration;
import com.example.epj2.model.electricvehicle.Bicycle;
import com.example.epj2.model.electricvehicle.Car;
import com.example.epj2.model.electricvehicle.Scooter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/**
 * Controller class for deserializeWindow.fxml file.
 */
public class DeserializeWindowController implements Initializable {

    private Car car;

    private Double carIncome;
    private Bicycle bicycle;

    private Double bicycleIncome;
    private Scooter scooter;

    private Double scooterIncome;
    @FXML
    private Label bicycleBattLvlLbl;

    @FXML
    private Label bicycleIdLbl;

    @FXML
    private Label bicycleManufacturerLbl;

    @FXML
    private Label bicycleModelLbl;

    @FXML
    private Label bicyclePriceLbl;

    @FXML
    private Label carBattLvlLbl;

    @FXML
    private Label carIdLbl;

    @FXML
    private Label carManufacturerLbl;

    @FXML
    private Label carModelLbl;

    @FXML
    private Label carPriceLbl;

    @FXML
    private Label dateLbl;

    @FXML
    private Label descriptionLbl;

    @FXML
    private Label drivingRngLbl;

    @FXML
    private Button exitBtn;

    @FXML
    private Label maxSpeedLbl;

    @FXML
    private Label scooterBattLvlLbl;

    @FXML
    private Label scooterIdLbl;

    @FXML
    private Label scooterManufacturerLbl;

    @FXML
    private Label scooterModelLbl;

    @FXML
    private Label scooterPriceLbl;

    @FXML
    private Label carIncomeLbl;

    @FXML
    private Label bicycleIncomeLbl;

    @FXML
    private Label scooterIncomeLbl;

    @FXML
    void exitBtnClicked(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * Constructs a new ReportsWindowController object.
     * @param car Car object that made the most income
     * @param bicycle Bicycle object that made the most income
     * @param scooter Scooter object that made the most income
     * @param carIncome the amount that Car object made
     * @param bicycleIncome the amount that Bicycle object made
     * @param scooterIncome the amount that Scooter object made
     */
    public DeserializeWindowController(Car car, Bicycle bicycle, Scooter scooter, Double carIncome, Double bicycleIncome, Double scooterIncome) {
        this.car = car;
        this.bicycle = bicycle;
        this.scooter = scooter;
        this.carIncome = carIncome;
        this.bicycleIncome = bicycleIncome;
        this.scooterIncome = scooterIncome;

    }

    /**
     * Initializes FXML objects on the window populating all labels.
     * @param location the URL of the FXML document used to create this window
     * @param resources the {@link ResourceBundle} used to localize the UI elements
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat(Configuration.getCarDateFormat());

            carIdLbl.setText(car.getVehicleId());
            carModelLbl.setText(car.getModel());
            carManufacturerLbl.setText(car.getManufacturer());
            carPriceLbl.setText(String.format("%.3f", car.getPrice()));
            carBattLvlLbl.setText(String.valueOf(car.getBatteryLevel()));
            descriptionLbl.setText(car.getDescription());
            dateLbl.setText(dateFormatter.format(car.getPurchaseDate()));
            carIncomeLbl.setText(String.format("%.3f", carIncome));

            bicycleIdLbl.setText(bicycle.getVehicleId());
            bicycleModelLbl.setText(bicycle.getModel());
            bicycleManufacturerLbl.setText(bicycle.getManufacturer());
            bicyclePriceLbl.setText(String.format("%.3f", bicycle.getPrice()));
            bicycleBattLvlLbl.setText(String.valueOf(bicycle.getBatteryLevel()));
            drivingRngLbl.setText(String.valueOf(bicycle.getDrivingRange()));
            bicycleIncomeLbl.setText(String.format("%.3f", bicycleIncome));

            scooterIdLbl.setText(scooter.getVehicleId());
            scooterModelLbl.setText(scooter.getModel());
            scooterManufacturerLbl.setText(scooter.getManufacturer());
            scooterPriceLbl.setText(String.format("%.3f", scooter.getPrice()));
            scooterBattLvlLbl.setText(String.valueOf(scooter.getBatteryLevel()));
            maxSpeedLbl.setText(String.valueOf(scooter.getMaxSpeed()));
            scooterIncomeLbl.setText(String.format("%.3f", scooterIncome));
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }



}
