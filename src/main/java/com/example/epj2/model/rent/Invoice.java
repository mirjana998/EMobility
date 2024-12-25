package com.example.epj2.model.rent;

import java.time.LocalDateTime;

/**
 * Represents the rental invoice.
 *  This class provides methods to access and manipulate invoice attributes.
 */
public class Invoice {
    private int id;
    private static int staticId = 0;
    private int rentId;
    private String userId;
    private String userLicence;
    private String vehicleId;
    private LocalDateTime dateTime;
    private double primaryPrice;
    private double finalPrice;
    private double promotion;
    private double discount;
    private double distance;

    /**
     * Constructs a new Invoice object.
     * @param rentId the identifier of the rent that invoice is for
     * @param userId the identification document number of a user (passport number if the user is foreigner, ID card number otherwise)
     * @param userLicence the driver licence number of the user
     * @param vehicleId the identifier of the electric vehicle
     * @param primaryPrice the primary price of the rent
     * @param finalPrice the final price of the rent
     * @param promotion the promotion value of the rent
     * @param discount the discount value of the rent
     * @param distance the distance coefficient of the rent
     * @param dateTime the date and time of the rent
     */
    public Invoice(int rentId, String userId, String userLicence, String vehicleId, double primaryPrice, double finalPrice, double promotion, double discount, double distance, LocalDateTime dateTime) {
        this.id = ++staticId;
        this.rentId = rentId;
        this.userId = userId;
        this.userLicence = userLicence;
        this.vehicleId = vehicleId;
        this.primaryPrice = primaryPrice;
        this.finalPrice = finalPrice;
        this.promotion = promotion;
        this.discount = discount;
        this.distance = distance;
        this.dateTime = dateTime;
    }

    /**
     * Gets the identifier of the invoice Object.
     * @return the identifier of the invoice Object
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new value of the identifier of the invoice Object.
     * @param id new identifier of the invoice Object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the identifier of the rent that invoice is for.
     * @return the identifier of the rent that invoice is for
     */
    public int getRentId() {
        return rentId;
    }

    /**
     * Gets the final price (total) on the invoice.
     * @return the final price on the rent
     */
    public double getFinalPrice() {
        return finalPrice;
    }

    /**
     * Gets the promotion value on the invoice.
     * @return the promotion value on the invoice
     */
    public double getPromotion() {
        return promotion;
    }

    /**
     * Sets new value of the promotion attribute.
     * @param promotion the new value of the promotion attribute
     */
    public void setPromotion(double promotion) {
        this.promotion = promotion;
    }

    /**
     * Gets the discount value on the invoice.
     * @return the discount value on the invoice
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets new value of the discount attribute.
     * @param discount the new value of the discount attribute
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Gets the value of distance coefficient on the invoice.
     * @return the value of the distance coefficient on the invoice
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets new value of the distance coefficient on the invoice.
     * @param distance the new value of the distance coefficient on the invoice
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Gets the identifier of the electric vehicle that is rented.
     * @return the identifier of the electric vehicle
     */
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * Gets the date and time of the rent.
     * @return the date and time of the rent
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
