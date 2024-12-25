package com.example.epj2.controller;

import com.example.epj2.model.electricvehicle.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller class for malfunctionWindow.fxml file.
 */
public class MalfunctionsWindowController implements Initializable {

    private List<Malfunction> malfunctionList;
    @FXML
    private TableColumn<Malfunction, LocalDateTime> dateCol;
    @FXML
    private TableColumn<Malfunction, String> descriptionCol;
    @FXML
    private Button exitBtn;
    @FXML
    private TableColumn<Malfunction, String> vehicleIdCol;
    @FXML
    private TableView<Malfunction> malfunctionsTableView;
    @FXML
    private TableColumn<Malfunction, String> vehicleTypeCol;
    @FXML
    private Label warningLbl;

    @FXML
    void exitBtnClicked(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * Constructs a new MalfunctionWindowController object using the list of malfunction Objects.
     * @param malfunctionList the list of Malfunction objects
     */
    public MalfunctionsWindowController(List<Malfunction> malfunctionList) {
        this.malfunctionList = malfunctionList;

    }

    /**
     * Initializes FXML objects on the window, populating the malfunction table and displaying a message if no malfunctions are found.
     * @param location the URL of the FXML document used to create this window
     * @param resources the {@link ResourceBundle} used to localize the UI elements
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Malfunction> malfunctions = FXCollections.observableArrayList(malfunctionList);
        if(this.malfunctionList.size()==0) {
            warningLbl.setText("Not any malfunction identified yet.");
        }
        vehicleIdCol.setCellValueFactory(new PropertyValueFactory<Malfunction,String>("vehicleId"));
        vehicleTypeCol.setCellValueFactory(new PropertyValueFactory<Malfunction,String>("vehicleType"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Malfunction,LocalDateTime>("dateTime"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<Malfunction,String>("description"));
        malfunctionsTableView.setItems(malfunctions);

    }



}