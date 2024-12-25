package com.example.epj2.controller;

import com.example.epj2.model.Configuration;
import com.example.epj2.model.electricvehicle.Bicycle;
import com.example.epj2.model.electricvehicle.Car;
import com.example.epj2.model.electricvehicle.ElectricVehicle;
import com.example.epj2.model.electricvehicle.Scooter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller class for allVehiclesWindow.fxml file.
 */
public class AllVehiclesWindowController implements Initializable {

    private List<Car> carList = new ArrayList<>();

    private List<Scooter> scooterList = new ArrayList<>();

    private List<Bicycle> bicycleList = new ArrayList<>();
    private ObservableList<Car> cars;
    private ObservableList<Bicycle> bicycles;
    private ObservableList<Scooter> scooters;
    @FXML
    private TableColumn<Bicycle, Integer> bicycleBatLevelCol;

    @FXML
    private TableColumn<Bicycle, Integer> bicycleDriveRangeCol;

    @FXML
    private TableColumn<Bicycle, String> bicycleIdCol;

    @FXML
    private TableColumn<Bicycle, String> bicycleManufacturerCol;

    @FXML
    private TableColumn<Bicycle, String> bicycleModelCol;

    @FXML
    private TableColumn<Bicycle, Double> bicyclePriceCol;

    @FXML
    private TableView<Bicycle> bicyclesTableView;

    @FXML
    private TableColumn<Car, Integer> carBatLevelCol;

    @FXML
    private TableColumn<Car, String> carDescriptionCol;

    @FXML
    private TableColumn<Car, String> carIdCol;

    @FXML
    private TableColumn<Car, String> carManufacturerCol;

    @FXML
    private TableColumn<Car, String> carModelCol;

    @FXML
    private TableColumn<Car, Double> carPriceCol;

    @FXML
    private TableColumn<Car, Date> carPurDateCol;

    @FXML
    private TableView<Car> carsTableView;

    @FXML
    private Button exitBtn;

    @FXML
    private TableColumn<Scooter, Integer> scooterBatLevelCol;

    @FXML
    private TableColumn<Scooter, String> scooterIdCol;

    @FXML
    private TableColumn<Scooter, String> scooterManufacturerCol;

    @FXML
    private TableColumn<Scooter, Integer> scooterMaxSpeedCol;

    @FXML
    private TableColumn<Scooter, String> scooterModelCol;

    @FXML
    private TableColumn<Scooter, Double> scooterPriceCol;

    @FXML
    private TableView<Scooter> scootersTableView;

    @FXML
    void exitBtnClicked(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * Constructs a new AllVehiclesWindowController object using the list of Vehicle Objects.
     * @param vehicleList the list of Vehicle objects
     */
    public AllVehiclesWindowController(List<ElectricVehicle> vehicleList) {
        for(ElectricVehicle electricVehicle : vehicleList ) {
            if(electricVehicle instanceof Car) {
                carList.add((Car)electricVehicle);
            }
            else if (electricVehicle instanceof Scooter) {
                scooterList.add((Scooter)electricVehicle);
            }
            else {
                bicycleList.add((Bicycle)electricVehicle);
            }
        }
        cars = FXCollections.observableArrayList();
        bicycles = FXCollections.observableArrayList();
        scooters = FXCollections.observableArrayList();
    }

    /**
     * Initializes FXML objects on the window, populating the cars table, the scooters table and the bicycles table.
     * @param location the URL of the FXML document used to create this window
     * @param resources the {@link ResourceBundle} used to localize the UI elements
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reloadData();
        carIdCol.setCellValueFactory(new PropertyValueFactory<Car,String>("vehicleId"));
        carModelCol.setCellValueFactory(new PropertyValueFactory<Car,String>("model"));
        carManufacturerCol.setCellValueFactory(new PropertyValueFactory<Car,String>("manufacturer"));
        carBatLevelCol.setCellValueFactory(new PropertyValueFactory<Car,Integer>("batteryLevel"));
        carPriceCol.setCellValueFactory(new PropertyValueFactory<Car,Double>("price"));
        carPurDateCol.setCellValueFactory(new PropertyValueFactory<Car, Date>("purchaseDate"));
        formatDateCells(carPurDateCol);
        carDescriptionCol.setCellValueFactory(new PropertyValueFactory<Car,String>("description"));
        carsTableView.setItems(cars);

        bicycleIdCol.setCellValueFactory(new PropertyValueFactory<Bicycle,String>("vehicleId"));
        bicycleModelCol.setCellValueFactory(new PropertyValueFactory<Bicycle,String>("model"));
        bicycleManufacturerCol.setCellValueFactory(new PropertyValueFactory<Bicycle,String>("manufacturer"));
        bicycleBatLevelCol.setCellValueFactory(new PropertyValueFactory<Bicycle,Integer>("batteryLevel"));
        bicyclePriceCol.setCellValueFactory(new PropertyValueFactory<Bicycle,Double>("price"));
        bicycleDriveRangeCol.setCellValueFactory(new PropertyValueFactory<Bicycle,Integer>("drivingRange"));
        bicyclesTableView.setItems(bicycles);

        scooterIdCol.setCellValueFactory(new PropertyValueFactory<Scooter,String>("vehicleId"));
        scooterModelCol.setCellValueFactory(new PropertyValueFactory<Scooter,String>("model"));
        scooterManufacturerCol.setCellValueFactory(new PropertyValueFactory<Scooter,String>("manufacturer"));
        scooterBatLevelCol.setCellValueFactory(new PropertyValueFactory<Scooter,Integer>("batteryLevel"));
        scooterPriceCol.setCellValueFactory(new PropertyValueFactory<Scooter,Double>("price"));
        scooterMaxSpeedCol.setCellValueFactory(new PropertyValueFactory<Scooter,Integer>("maxSpeed"));
        scootersTableView.setItems(scooters);
    }

    private void reloadData() {
        cars.clear();
        cars.addAll(carList);
        bicycles.clear();
        bicycles.addAll(bicycleList);
        scooters.clear();
        scooters.addAll(scooterList);
        carsTableView.setItems(null);
        bicyclesTableView.setItems(null);
        scootersTableView.setItems(null);
    }

    private void formatDateCells(TableColumn<Car, Date> column) {
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat(Configuration.getCarDateFormat());
            column.setCellFactory(new Callback<>() {
                @Override
                public TableCell<Car, Date> call(TableColumn<Car, Date> param) {
                    return new TableCell<>() {
                        @Override
                        protected void updateItem(Date item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty || item == null) {
                                setText(null);
                            } else {
                                setText(dateFormatter.format(item));
                            }
                        }
                    };
                }
            });
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
