package com.example.epj2.model.electricvehicle;

import com.example.epj2.model.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents an electric car.
 * This class provides methods to access and manipulate car attributes.
 */
public class Car extends ElectricVehicle {

    private String imageFile;
    private Date purchaseDate;
    private String description;
    private List<String> passenger;

    /**
     * Constructs a new Car object.
     * @param id the identifier of the car
     * @param price the prices of the car
     * @param manufacturer the manufacturer of the car
     * @param model the model of the car
     * @param purchaseDate the purchase date of the dar
     * @param description the description of the car
     */
    public Car(String id, double price, String manufacturer, String model, int batteryLevel, Date purchaseDate, String description) {
        super(id,price, manufacturer, model, batteryLevel);
        this.purchaseDate = purchaseDate;
        this.description = description;
        this.passenger = new ArrayList<>();
        try {
            imageFile = Configuration.getCarImageFile();
            InitializeImage(imageFile);
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Constructs a new Car object with attributes of car parameter.
     * @param car the Car object on the basis of which a new one will be made
     */
    public Car(Car car) {
        super(car.getVehicleId(),car.getPrice(), car.getManufacturer(), car.getModel(), car.getBatteryLevel());
        this.purchaseDate = car.getPurchaseDate();
        this.description = car.getDescription();
        this.passenger = car.getPassenger();
        try {
            imageFile = Configuration.getCarImageFile();
            InitializeImage(imageFile);
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Gets the purchase date of the car.
     * @return the purchase date of the car
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Gets the description of the car.
     * @return the description of the car
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the list of passengers in the car.
     * @return the list of passengers in the car
     */
    public List<String> getPassenger() {
        return passenger;
    }

    /**
     * Returns the string representation of the Car object.
     * @return the string representation of the car
     */
    @Override
    public String toString() {
        return (super.toString() + "\npurchase date: " + purchaseDate + "\ndescription: " + description);
    }
}
