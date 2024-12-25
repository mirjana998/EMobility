package com.example.epj2.controller;

import com.example.epj2.model.Configuration;
import com.example.epj2.model.electricvehicle.Car;
import com.example.epj2.model.rent.Report;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller class for reportsWindow.fxml file.
 */
public class ReportsWindowController implements Initializable {
    private static List<Report> reportsList = new ArrayList<>();

    private Double summaryIncome;

    private Double summaryDiscount;

    private Double summaryPromotion;

    private Double summaryIncomeWide;

    private Double summaryIncomeNarrow;

    private Double summaryMaintenance;

    private Double summaryRepair;

    private Double summaryCosts;

    private Double summaryTax;
    @FXML
    private Button exitBtn;

    @FXML
    private TableColumn<Report, LocalDate> reportDateCol;

    @FXML
    private TableColumn<Report, Double> reportDiscountCol;

    @FXML
    private TableColumn<Report, Double> reportIncomeNarrowCol;

    @FXML
    private TableColumn<Report, Double> reportIncomeWideCol;

    @FXML
    private TableColumn<Report, Double> reportIncomeCol;

    @FXML
    private TableColumn<Report, Double> reportMaintenanceCol;

    @FXML
    private TableColumn<Report, Double> reportPromotionCol;

    @FXML
    private TableColumn<Report, Double> reportRepairCol;

    @FXML
    private TableView<Report> reportTableView;

    @FXML
    private Label warningLbl;

    @FXML
    private Label summaryDiscountLbl;

    @FXML
    private Label summaryIncomeNarrowLbl;

    @FXML
    private Label summaryIncomeWideLbl;

    @FXML
    private Label summaryIncomeLbl;

    @FXML
    private Label summaryMaintenanceLbl;

    @FXML
    private Label summaryPromotionLbl;

    @FXML
    private Label summaryRepairLbl;

    @FXML
    private Label summaryTaxLbl;

    @FXML
    private Label summaryCostsLbl;


    @FXML
    void exitBtnClicked(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * Constructs a new ReportsWindowController object using the list of Report Objects.
     * @param reportList the list of Report objects
     */
    public ReportsWindowController(List<Report> reportList) {
        reportsList = reportList;
        summaryIncome = 0.0;
        summaryDiscount = 0.0;
        summaryPromotion = 0.0;
        summaryMaintenance = 0.0;
        summaryIncomeNarrow = 0.0;
        summaryIncomeWide = 0.0;
        summaryRepair = 0.0;
    }

    /**
     * Initializes FXML objects on the window, populating the daily reports table, displaying a message if no malfunctions are found.
     * It also calculates attributes of summary report and display them in corresponding labels.
     * @param location the URL of the FXML document used to create this window
     * @param resources the {@link ResourceBundle} used to localize the UI elements
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Report> reports = FXCollections.observableArrayList(reportsList);

        if(reportsList.size()==0) {
            warningLbl.setText("No reports to show yet.");
        }
        else {
            for(Report report: reportsList) {
                summaryIncome += report.getIncomeTotal();
                summaryRepair += report.getRepairTotal();
                summaryPromotion += report.getPromotionTotal();
                summaryDiscount += report.getDiscountTotal();
                summaryIncomeNarrow += report.getIncomeNarrowTotal();
                summaryIncomeWide += report.getIncomeWideTotal();
                summaryMaintenance += report.getMaintenanceTotal();
            }
            summaryIncomeLbl.setText(String.format("%.3f", summaryIncome));
            summaryDiscountLbl.setText(String.format("%.3f", summaryDiscount));
            summaryPromotionLbl.setText(String.format("%.3f",summaryPromotion ));
            summaryIncomeWideLbl.setText(String.format("%.3f", summaryIncomeWide));
            summaryIncomeNarrowLbl.setText(String.format("%.3f", summaryIncomeNarrow));
            summaryMaintenanceLbl.setText(String.format("%.3f", summaryMaintenance));
            summaryRepairLbl.setText(String.format("%.3f", summaryRepair));
            try {
                summaryCosts = summaryIncome * Double.parseDouble(Configuration.getCostCoefficientProp());
                summaryCostsLbl.setText(String.format("%.3f", summaryCosts));
                summaryTax = (summaryIncome - summaryMaintenance - summaryRepair - summaryCosts) * Double.parseDouble(Configuration.getTaxCoefficientProp());
                summaryTaxLbl.setText(String.format("%.3f", summaryTax));
            }catch (IOException exception) {
                exception.printStackTrace();
            }

        }
        reportDateCol.setCellValueFactory(new PropertyValueFactory<Report,LocalDate>("date"));
        reportIncomeCol.setCellValueFactory(new PropertyValueFactory<Report,Double>("incomeTotal"));
        formatColumnDecimal(reportIncomeCol);
        reportDiscountCol.setCellValueFactory(new PropertyValueFactory<Report,Double>("discountTotal"));
        formatColumnDecimal(reportDiscountCol);
        reportPromotionCol.setCellValueFactory(new PropertyValueFactory<Report,Double>("promotionTotal"));
        formatColumnDecimal(reportPromotionCol);
        reportMaintenanceCol.setCellValueFactory(new PropertyValueFactory<Report,Double>("maintenanceTotal"));
        formatColumnDecimal(reportMaintenanceCol);
        reportIncomeNarrowCol.setCellValueFactory(new PropertyValueFactory<Report,Double>("incomeNarrowTotal"));
        formatColumnDecimal(reportIncomeNarrowCol);
        reportIncomeWideCol.setCellValueFactory(new PropertyValueFactory<Report,Double>("incomeWideTotal"));
        formatColumnDecimal(reportIncomeWideCol);
        reportRepairCol.setCellValueFactory(new PropertyValueFactory<Report,Double>("repairTotal"));
        formatColumnDecimal(reportRepairCol);
        reportTableView.setItems(reports);

    }


    private void formatColumnDecimal(TableColumn<Report, Double> column) {
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        column.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Report, Double> call(TableColumn<Report, Double> column) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(Double item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(decimalFormat.format(item));
                        }
                    }
                };
            }
        });
    }


}
