package com.example.epj2.model.rent;

import com.example.epj2.controller.MainWindowController;
import com.example.epj2.model.Configuration;
import com.example.epj2.model.electricvehicle.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;



/**
 * Represents the rent of an electric vehicle.
 * This class provides methods to access and manipulate rent attributes.
 */
public class Rent {
    private int id;
    private static int staticId = 0;
    private LocalDateTime dateTime;
    private String user;
    private String vehicleId;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int duration;
    private double finalPrice;
    private double primaryPrice;
    private double discount;
    private boolean hasMalfunction;
    private boolean hasPromotion;
    private double promotion;
    private boolean distanceWideRate;
    private double distance;

    private boolean hasDiscount;

    /**
     * Constructs a new Rent object with specified attribute.
     * @param dateTime the date and time the rent was made
     * @param user the username of the user who rented the electric vehicle
     * @param vehicleId the identifier of the rented electric vehicle
     * @param startX the starting position of the rent on the x-axis
     * @param startY the starting position of the rent on the y-axis
     * @param endX the ending position of the rent on the x-axis
     * @param endY the ending position of the rent on the y-axis
     * @param duration the duration of the rent in seconds
     * @param hasMalfunction {@code true} if a malfunction happened during the rent of the vehicle, {@code false} otherwise
     * @param hasPromotion {@code true} if there is rent promotion, {@code false} otherwise
     */
    public Rent(LocalDateTime dateTime, String user, String vehicleId, int startX, int startY, int endX, int endY, int duration, boolean hasMalfunction, boolean hasPromotion) {
        this.id = staticId++;
        this.dateTime = dateTime;
        this.user = user;
        this.vehicleId = vehicleId;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.duration = duration;
        this.hasMalfunction = hasMalfunction;
        this.hasPromotion = hasPromotion;
        this.distanceWideRate = false;
        this.hasDiscount = false;
    }

    /**
     * Gets the value of a malfunction attribute.
     * @return {@code true} if a malfunction happened during the rent of the vehicle, {@code false} otherwise
     */
    public boolean isHasMalfunction() {
        return hasMalfunction;
    }

    /**
     * Gets the identifier of the rented electric vehicle.
     * @return the identifier of the rented electric vehicle
     */
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * Gets the rent identifier.
     * @return the rent identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the date and time the rent was made.
     * @return the date and time the rent was made.
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Gets the username of the user who made a rent.
     * @return the username of the user who made a rent.
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets new username of the user who made a rent.
     * @param user the new username of the user who made a rent
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets the starting position of the rent on the x-axis.
     * @return the starting position of the rent on the x-axis
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Gets the starting position of the rent on the y-axis.
     * @return the starting position of the rent on the y-axis
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Gets the ending position of the rent on the x-axis.
     * @return the ending position of the rent on the x-axis
     */
    public int getEndX() {
        return endX;
    }

    /**
     * Gets the ending position of the rent on the y-axis.
     * @return the ending position of the rent on the y-axis
     */
    public int getEndY() {
        return endY;
    }

    /**
     * Gets the duration of the rent in seconds.
     * @return the duration of the rent in seconds
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets the discount value of a rent.
     * @return the discount value of a rent
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets new discount value of a rent.
     * @param discount the new discount value of a rent
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Gets the promotion value of a rent.
     * @return the promotion value of a rent
     */
    public double getPromotion() {
        return promotion;
    }

    /**
     * Sets new promotion value of a rent.
     * @param promotion the new promotion value of a rent
     */
    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }

    /**
     * Sets new value of a variable that indicates if there is a discount in rent.
     * @param hasDiscount {@code true} if there is rent discount, {@code false} otherwise
     */
    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    /**
     * Gets the value of a variable that indicates if the rent happened in outer city (at least one field).
     * @return {@code true} if rent happened in outer city, {@code false} otherwise
     */
    public boolean isDistanceWideRate() {
        return distanceWideRate;
    }

    /**
     * Gets new value of a variable that indicates if the rent happened in outer city (at least one field).
     * @param distanceWideRate {@code true} if rent happened in outer city, {@code false} otherwise
     */
    public void setDistanceWideRate(boolean distanceWideRate) {
        this.distanceWideRate = distanceWideRate;
    }

    /**
     * Gets the final price that user have to pay for the rent.
     * @return the final price that user have to pay for the rent
     */
    public double getFinalPrice() {
        return finalPrice;
    }

    /**
     * Gets the primary price used for other prices calculation.
     * @return the primary price used for other prices calculation
     */
    public double getPrimaryPrice() {
        return primaryPrice;
    }

    /**
     * Gets the distance price used for final price calculation.
     * @return the distance price used for final price calculation
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets new distance price used for final price calculation.
     * @param distance the new distance price used for final price calculation
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }


    private void calculatePrimaryPrice() throws IOException {
        Optional<ElectricVehicle> optionalVehicle = MainWindowController.currentVehicles.stream().filter(vehicle -> vehicle.getVehicleId().equals(this.getVehicleId())).findFirst();
        if(optionalVehicle.isPresent()) {
            ElectricVehicle electricVehicle = optionalVehicle.get();
            String vehicleUnitPrice;
            if (electricVehicle instanceof Car) {
                vehicleUnitPrice = Configuration.getCarUnitPriceProp();
            } else if (electricVehicle instanceof Bicycle) {
                vehicleUnitPrice = Configuration.getBikeUnitPriceProp();
            } else {
                vehicleUnitPrice = Configuration.getScooterUnitPriceProp();
            }
            primaryPrice = Double.parseDouble(vehicleUnitPrice) * duration;
        }
    }

    private void calculatePromotion(double sum) throws IOException{
        if(hasPromotion) {
            promotion = sum * (Double.parseDouble(Configuration.getDiscountPromProp())/100); //convert percentage to decimal value
        }
    }

    //every user gets discount for its 10th ride
    private void calculateDiscount(double sum) throws IOException{
        if(hasDiscount) {
            discount = sum * (Double.parseDouble(Configuration.getDiscountProp())/100);
        }
    }

    private void calculateMalfunction() throws IOException{
        if(hasMalfunction) {
            primaryPrice = 0;
        }
    }

    private void calculateDistance() throws IOException {
        if(distanceWideRate) {
            //distance = primaryPrice * Double.parseDouble(Configuration.getDistanceWideProp());
            distance = Double.parseDouble(Configuration.getDistanceWideProp());
        }
        else {
           // distance = primaryPrice * Double.parseDouble(Configuration.getDistanceNarrowProp());
            distance = Double.parseDouble(Configuration.getDistanceWideProp());
        }
    }

    /**
     * Calculates all attribute values including: promotion, discount, primary price, distance coefficient and final price.
     */
    public void calculateFinalPrice() {
        try {
            calculatePrimaryPrice();
            calculateMalfunction();
            calculateDistance();
            double sum = primaryPrice * distance;
            calculatePromotion(sum);
            calculateDiscount(sum);
            finalPrice = sum - promotion - discount;
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Returns string representation of the rent.
     * @return a string representation of the rent, including the rent identifier, user identifier, rented vehicle identifier, the date and time of the rent and with starting and ending positions
     */
    @Override
    public String toString() {
        return "\n========\nRent id: " + id + "\nuser id: " + user + "\nvehicle id: " + vehicleId + "\ndate: " + dateTime + "\nstart (x,y)=(" + startX + "," + startY + ")" + "\nend (x,y)=(" + endX + "," + endY + ")";
    }

}
