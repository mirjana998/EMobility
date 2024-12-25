package com.example.epj2.model.rent;

/**
 *  Represents an electric vehicle user (driver or passenger).
 *  This class provides methods to access and manipulate users attributes.
 */
public class User {
    private static int staticId = 0;
    private String username;
    private String driversLicenceNumber;
    private boolean isForeigner;
    private String idCard;
    private String passport;
    private int rentCounter;

    /**
     * Constructor for User class.
     * @param username the username of a user.
     */
    public User(String username) {
        this.username = username;
        this.driversLicenceNumber = "DL" + ++staticId;
        this.isForeigner = (staticId % 5 == 0);
        this.idCard = "ID" + staticId;
        this.passport = "PASS" + staticId;
        this.rentCounter = 0;
    }

    /**
     * Gets the value of rentCounter attribute.
     * @return the value represents how many times user had rented an electric vehicle.
     */
    public int getRentCounter() {
        return rentCounter;
    }

    /**
     * Increases the value of rentCounter attribute by one when user make a new rent.
     */
    public void increaseRentCounter() {
        ++this.rentCounter;
    }

    /**
     * Returns whether the user is foreigner.
     * @return {@code true} if the user is a foreigner, {@code false} otherwise.
     */
    public boolean isForeigner() {
        return isForeigner;
    }

    /**
     * Gets the passports.
     * @return the passport.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Gets the username.
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the driver licence number as a string.
     * @return the driver licence number.
     */
    public String getDriversLicenceNumber() {
        return driversLicenceNumber;
    }

    /**
     * Gets the ID card number as a string.
     * @return the ID card number.
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * Returns string representation of user.
     * @return a string representation of the user, including the username, driver's license number, ID card number, and passport number.
     */
    @Override
    public String toString() {
        return "\nUser: " + username + "\ndrivers licence: " +driversLicenceNumber + "\nid card: " + idCard + "\npassport number: " + passport;
    }
}
