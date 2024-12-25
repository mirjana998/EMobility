package com.example.epj2.model.electricvehicle;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Represents a malfunction of an electric vehicle.
 * This class provides methods to access and manipulate malfunction attributes.
 */
public class Malfunction {

    private int id;
    private static int staticId = 0;
    private String description;
    private LocalDateTime dateTime;
    private String vehicleId;
    private String vehicleType;

    /**
     * Constructs a new Malfunction object for vehicle whose identifier is in the list of parameters.
     * @param dateTime the date and time when the malfunction happened
     * @param vehicleId the identifier of the vehicle where malfunction happened
     */
    public Malfunction(LocalDateTime dateTime, String vehicleId) {
        id = staticId++;
        this.description = "Description " + id;
        this.dateTime = dateTime;
        this.vehicleId = vehicleId;
        this.vehicleType = "electric vehicle";
    }

    /**
     * Gets the identifier of the malfunction.
     * @return the identifier of the malfunction
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new identifier of the malfunction.
     * @param id the new identifier of the malfunction
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the identifier of the vehicle where malfunction happened.
     * @return the identifier of the vehicle
     */
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * Gets the description of the malfunction.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the date and time of the malfunction.
     * @return the date and time of the malfunction
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Gets the type of the vehicle where malfunction happened.
     * @return the type of vehicle where malfunction happened
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Updates vehicle type according to type of electric vehicle parameter.
     * @param electricVehicle the electric vehicle
     */
    public void updateVehicleType(ElectricVehicle electricVehicle) {
        if(electricVehicle instanceof Car) {
            this.vehicleType = "car";
        }
        else if(electricVehicle instanceof Bicycle) {
            this.vehicleType = "bicycle";
        }
        else {
            this.vehicleType = "scooter";
        }
    }

    /**
     * Returns the string representation of the Malfunction object.
     * @return the string representation of the malfunction
     */
    @Override
    public String toString() {
        return "Malfunction: " + "\nid: " + id + "\ndescription: " + description + "\ndate: " + dateTime;
    }
}
