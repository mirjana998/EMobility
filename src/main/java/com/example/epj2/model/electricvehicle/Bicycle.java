package com.example.epj2.model.electricvehicle;

import com.example.epj2.model.Configuration;

import java.io.IOException;

/**
 * Represents an electric bicycle.
 * This class provides methods to access and manipulate bicycle attributes.
 */
public class Bicycle extends ElectricVehicle {

    private String imageFile;
    private int drivingRange;

    /**
     * Constructs a new Bicycle object.
     * @param id the identifier of the bicycle
     * @param price the prices of the bicycle
     * @param manufacturer the manufacturer of the bicycle
     * @param model the model of the bicycle
     * @param batteryLevel the battery level of the bicycle
     * @param drivingRange the driving range of the bicycle
     */
    public Bicycle(String id, double price, String manufacturer, String model, int batteryLevel, int drivingRange) {
        super(id,price, manufacturer, model, batteryLevel);
        this.drivingRange = drivingRange;
        try {
            imageFile = Configuration.getBicycleImageFile();
            InitializeImage(imageFile);
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Constructs a new Bicycle object with attributes of bicycle parameter.
     * @param bicycle the Bicycle object on the basis of which a new one will be made
     */
    public Bicycle(Bicycle bicycle) {
        super(bicycle.getVehicleId(),bicycle.getPrice(), bicycle.getManufacturer(), bicycle.getModel(), bicycle.getBatteryLevel());
        this.drivingRange = bicycle.getDrivingRange();
        try {
            imageFile = Configuration.getBicycleImageFile();
            InitializeImage(imageFile);
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Gets the driving range of the bicycle
     * @return the driving range of the bicycle
     */
    public int getDrivingRange() {
        return drivingRange;
    }

    /**
     * Returns the string representation of the Bicycle object.
     * @return the string representation of the bicycle
     */
    @Override
    public String toString() {
        return (super.toString() + "\ndriving range: " + drivingRange);
    }


}
