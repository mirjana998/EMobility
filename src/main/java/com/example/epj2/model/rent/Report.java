package com.example.epj2.model.rent;

import com.example.epj2.controller.MainWindowController;
import com.example.epj2.model.Configuration;
import com.example.epj2.model.electricvehicle.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


/**
 * Represents the daily report of all income and expenses of an electric vehicle rental company.
 * This class provides methods to access and manipulate report attributes.
 */
public class Report {
    private LocalDate date;
    private double incomeTotal;
    private double discountTotal;
    private double promotionTotal;
    private double incomeNarrowTotal;
    private double incomeWideTotal;
    private double maintenanceTotal;
    private double repairTotal;

    /**
     * Constructs new Report object.
     * Goes through a list of invoices made on the same day and calculates income and expenses attributes.
     * @param date the date of report
     * @param invoiceList the list of invoices created on same date
     */
    public Report(LocalDate date, List<Invoice> invoiceList) {
        this.date = date;
        calculateIncome(invoiceList);
        calculateDiscount(invoiceList);
        calculatePromotion(invoiceList);
        calculateIncomeWideNarrow(invoiceList);
        try {
            calculateMaintenance();
            calculateRepair(invoiceList);
        }catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    /**
     * Get the date of report.
     * @return the date of report.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets new value of date report.
     * @param date the new value of date report.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *  Gets total income from invoices made on the same date.
     * @return the total income from invoices made on the same date
     */
    public double getIncomeTotal() {
        return incomeTotal;
    }

    /**
     *  Gets all discount value from invoices made on the same date.
     * @return the total discount value from invoices made on the same date
     */
    public double getDiscountTotal() {
        return discountTotal;
    }

    /**
     *  Gets the total promotion value from invoices made on the same date.
     * @return the total promotion value from invoices made on the same date
     */
    public double getPromotionTotal() {
        return promotionTotal;
    }

    /**
     * Gets the total income from invoices made for inner city driving.
     * @return the total income made for inner city driving
     */
    public double getIncomeNarrowTotal() {
        return incomeNarrowTotal;
    }

    /**
     * Gets the total income from invoices made for outer city driving.
     * @return the total income made for outer city driving
     */
    public double getIncomeWideTotal() {
        return incomeWideTotal;
    }

    /**
     * Gets the total maintenance costs from invoices made on the same day
     * @return the total maintenance costs from invoices made on the same day
     */
    public double getMaintenanceTotal() {
        return maintenanceTotal;
    }

    /**
     * Gets the total repair costs from invoices made on the same day
     * @return the total repair costs from invoices made on the same day
     */
    public double getRepairTotal() {
        return repairTotal;
    }

    private void calculateIncome(List<Invoice> invoiceList) {
        incomeTotal = 0;
        invoiceList.forEach(item->{incomeTotal+=item.getFinalPrice();});
    }

    private void calculateDiscount(List<Invoice> invoiceList) {
        discountTotal = 0;
        invoiceList.forEach(item->{discountTotal+=item.getDiscount();});
    }

    private void calculatePromotion(List<Invoice> invoiceList) {
        promotionTotal = 0;
        invoiceList.forEach(item->{promotionTotal+=item.getPromotion();});
    }

    private void calculateIncomeWideNarrow(List<Invoice> invoiceList) {
        incomeWideTotal = 0;
        incomeNarrowTotal = 0;
        for(Invoice invoice : invoiceList) {
            Optional<Rent> optionalRent = MainWindowController.rentList.stream().filter(rent->rent.getId()==invoice.getRentId()).findFirst();
            if(optionalRent.isPresent()) {
                Rent rent = optionalRent.get();
                if(rent.isDistanceWideRate()) {
                    incomeWideTotal += invoice.getFinalPrice();
                }
                else {
                    incomeNarrowTotal += invoice.getFinalPrice();
                }
            }
        }

    }

    private void calculateMaintenance() throws IOException {
        maintenanceTotal = Double.parseDouble(Configuration.getMaintenanceCoefficientProp())*incomeTotal;
    }

    private void calculateRepair(List<Invoice> invoiceList) throws IOException {
        repairTotal = 0;
        for(Invoice invoice : invoiceList) {
            Optional<Rent> optionalRent = MainWindowController.rentList.stream().filter(rent -> rent.getId() == invoice.getRentId()).findFirst();
            if (optionalRent.isPresent()) {
                Rent rent = optionalRent.get();
                if (rent.isHasMalfunction()) {
                    Optional<ElectricVehicle> optionalVehicle = MainWindowController.vehicleList.stream().filter(vehicle -> vehicle.getVehicleId().equals(invoice.getVehicleId())).findFirst();
                    if (optionalVehicle.isPresent()) {
                        ElectricVehicle electricVehicle = optionalVehicle.get();
                        double repairVehicle;
                        if (electricVehicle instanceof Car) {
                            repairVehicle = Double.parseDouble(Configuration.getCarCoefficientProp()) * electricVehicle.getPrice();
                        } else if (electricVehicle instanceof Bicycle) {
                            repairVehicle = Double.parseDouble(Configuration.getBicycleCoefficientProp()) * electricVehicle.getPrice();
                        } else {
                            repairVehicle = Double.parseDouble(Configuration.getScooterCoefficientProp()) * electricVehicle.getPrice();
                        }
                        repairTotal += repairVehicle;
                    }
                }
            }
        }
    }


}
