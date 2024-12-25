package com.example.epj2.model.electricvehicle;


import com.example.epj2.model.Configuration;

import java.io.IOException;

/**
 * Represents an electric scooter.
 * This class provides methods to access and manipulate scooter attributes.
 */
public class Scooter extends ElectricVehicle {

    private String imageFile;
    private int maxSpeed;

    /**
     * Constructs a new Scooter object.
     * @param id the identifier of the scooter
     * @param price the prices of the scooter
     * @param manufacturer the manufacturer of the scooter
     * @param model the model of the scooter
     * @param batteryLevel the battery level of the scooter
     * @param maxSpeed the max speed of the scooter
     */
    public Scooter(String id, double price, String manufacturer, String model, int batteryLevel, int maxSpeed) {
        super(id,price, manufacturer, model, batteryLevel);
        this.maxSpeed = maxSpeed;
        try {
            imageFile = Configuration.getScooterImageFile();
            InitializeImage(imageFile);
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Constructs a new Scooter object with attributes of scooter parameter.
     * @param scooter the Scooter object on the basis of which a new one will be made
     */
    public Scooter(Scooter scooter) {
        super(scooter.getVehicleId(),scooter.getPrice(), scooter.getManufacturer(), scooter.getModel(), scooter.getBatteryLevel());
        this.maxSpeed = scooter.getMaxSpeed();
        try {
            imageFile = Configuration.getScooterImageFile();
            InitializeImage(imageFile);
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Gets the max speed of the scooter.
     * @return the max speed of the scooter
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Returns the string representation of Scooter object.
     * @return the string representation of the scooter
     */
    @Override
    public String toString() {
        return (super.toString() + "\nmax speed: " + maxSpeed);
    }
}
