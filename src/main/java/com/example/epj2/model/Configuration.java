package com.example.epj2.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class for managing properties.
 * This class provides methods for accessing properties from a properties file.
 */
public class Configuration {

    private static final String rentsFile ="rents_file";
    private static final String vehiclesFile="vehicles_file";
    private static final String propertiesFile = "properties.txt";
    private static final String carCoefficientProp = "car_coefficient";
    private static final String bicycleCoefficientProp= "bicycle_coefficient";
    private static final String scooterCoefficientProp = "scooter_coefficient";
    private static final String maintenanceCoefficientProp = "maintenance_coefficient";
    private static final String costCoefficientProp = "cost_coefficient";
    private static final String taxCoefficientProp = "tax_coefficient";
    private static final String distanceWideProp = "distance_wide";
    private static final String distanceNarrowProp = "distance_narrow";
    private static final String discountProp = "discount";
    private static final String discountPromProp = "discount_prom";
    private static final String carUnitPriceProp = "car_unit_price";
    private static final String bikeUnitPriceProp = "bike_unit_price";
    private static final String scooterUnitPriceProp = "scooter_unit_price";
    private static final String invoicePathProp = "invoice_path";
    private static final String picturePathProp = "picture_path";
    private static final String serializePathProp = "serialize_path";

    private static final String carSerializeFile = "car_serialized";

    private static final String bicycleSerializeFile = "bicycle_serialized";

    private static final String scooterSerializeFile = "scooter_serialized";

    private static final String carIncomeSerializeFile = "car_income_serialized";

    private static final String bicycleIncomeSerializeFile = "bicycle_income_serialized";

    private static final String scooterIncomeSerializeFile = "scooter_income_serialized";
    private static final String userDirProp = "user.dir";
    private static final String scooterImageFile = "scooter_image_file";
    private static final String bicycleImageFile = "bicycle_image_file";
    private static final String carImageFile = "car_image_file";
    private static final String carVehicleType= "car_vehicle_type";
    private static final String bicycleVehicleType="bicycle_vehicle_type";
    private static final String scooterVehicleType="scooter_vehicle_type";
    private static final String vehiclesAttributesNumber="vehicles_attributes";
    private static final String rentsAttributesNumber="rents_attributes";
    private static final String rentDateFormat="rent_date_format";
    private static final String carDateFormat="car_date_format";
    private static final String fileRegex="file_regex";

    private static final String userDiscount="user_discount_counter";


    private static Properties loadProperties() throws IOException {
        String filePath = Thread.currentThread().getContextClassLoader().getResource(propertiesFile).getPath();
        Properties properties = new Properties();
        properties.load(new FileInputStream(filePath));
        return properties;
    }

    /**
     * Retrieves the coefficient property for cars from the properties file.
     * @return the coefficient property for cars
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getCarCoefficientProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(carCoefficientProp);
    }

    /**
     * Retrieves the coefficient property for bicycles from the properties file.
     * @return the coefficient property for bicycles
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getBicycleCoefficientProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(bicycleCoefficientProp);
    }

    /**
     * Retrieves the coefficient property for scooters from the properties file.
     * @return the coefficient property for scooters
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getScooterCoefficientProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(scooterCoefficientProp);
    }

    /**
     * Retrieves the maintenance coefficient property from the properties file.
     * @return the maintenance coefficient property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getMaintenanceCoefficientProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(maintenanceCoefficientProp);
    }

    /**
     * Retrieves the invoice cost coefficient property from the properties file.
     * @return the invoice cost coefficient property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getCostCoefficientProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(costCoefficientProp);
    }

    /**
     * Retrieves the invoice tax coefficient property from the properties file.
     * @return the invoice tax coefficient property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getTaxCoefficientProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(taxCoefficientProp);
    }

    /**
     * Retrieves the distance_wide property from the properties file.
     * @return the distance_wide property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getDistanceWideProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(distanceWideProp);
    }

    /**
     * Retrieves the distance_narrow property from the properties file.
     * @return the distance_narrow property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getDistanceNarrowProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(distanceNarrowProp);
    }

    /**
     * Retrieves the discount property from the properties file.
     * @return the discount property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getDiscountProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(discountProp);
    }

    /**
     * Retrieves the discount_prom property from the properties file.
     * @return the discount_prom property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getDiscountPromProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(discountPromProp);
    }

    /**
     * Retrieves the car_unit_price property from the properties file.
     * @return the car_unit_price  property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getCarUnitPriceProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(carUnitPriceProp);
    }

    /**
     * Retrieves the bike_unit_price property from the properties file.
     * @return the bike_unit_price  property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getBikeUnitPriceProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(bikeUnitPriceProp);
    }

    /**
     * Retrieves the scooter_unit_price property from the properties file.
     * @return the scooter_unit_price  property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getScooterUnitPriceProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(scooterUnitPriceProp);
    }

    /**
     * Returns the name or the properties file.
     * @return the name of the properties file
     */
    public static String getPropertiesFile() {
        return propertiesFile;
    }

    /**
     * Retrieves the invoice_path property from the properties file.
     * @return the invoice_path property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getInvoicePathProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(invoicePathProp);
    }

    /**
     * Retrieves the picture_path property from the properties file.
     * @return the picture_path property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getPicturePathProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(picturePathProp);
    }

    /**
     * Retrieves the value of the system property "user.dir".
     * This property specifies the user's current working directory.
     * @return the value of the system property "user.dir"
     */
    public static String getUserDirProp() {
        return System.getProperty(userDirProp);
    }

    /**
     * Retrieves the scooter_image_file property from the properties file.
     * @return the scooter_image_file property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getScooterImageFile() throws IOException{
        Properties properties = loadProperties();
        return properties.getProperty(scooterImageFile);
    }

    /**
     * Retrieves the bicycle_image_file property from the properties file.
     * @return the bicycle_image_file property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getBicycleImageFile() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(bicycleImageFile);
    }

    /**
     * Retrieves the car_image_file property from the properties file.
     * @return the car_image_file property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getCarImageFile() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(carImageFile);
    }

    /**
     * Retrieves the car_vehicle_type property from the properties file.
     * @return the car_vehicle_type property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getCarVehicleType() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(carVehicleType);
    }

    /**
     * Retrieves the bicycle_vehicle_type property from the properties file.
     * @return the bicycle_vehicle_type property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getBicycleVehicleType() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(bicycleVehicleType);
    }

    /**
     * Retrieves the scooter_vehicle_type property from the properties file.
     * @return the scooter_vehicle_type property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getScooterVehicleType() throws IOException{
        Properties properties = loadProperties();
        return properties.getProperty(scooterVehicleType);
    }

    /**
     * Retrieves the vehicles_attributes property from the properties file.
     * @return the vehicles_attributes property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getVehiclesAttributesNumber() throws IOException{
        Properties properties = loadProperties();
        return properties.getProperty(vehiclesAttributesNumber);
    }

    /**
     * Retrieves the rents_attributes property from the properties file.
     * @return the rents_attributes property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getRentsAttributesNumber() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(rentsAttributesNumber);
    }

    /**
     * Retrieves the rent_date_format property from the properties file.
     * @return the rent_date_format property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getRentDateFormat() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(rentDateFormat);
    }

    /**
     * Retrieves the car_date_format property from the properties file.
     * @return the car_date_format property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getCarDateFormat() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(carDateFormat);
    }

    /**
     * Retrieves the file_regex property from the properties file.
     * @return the file_regex property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getFileRegex() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(fileRegex);
    }

    /**
     * Retrieves the user_discount_counter property from the properties file.
     * @return the user_discount_counter property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getUserDiscount() throws IOException{
        Properties properties = loadProperties();
        return properties.getProperty(userDiscount);
    }

    /**
     * Retrieves the serialize_path property from the properties file.
     * @return the serialize_path property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getSerializePathProp() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(serializePathProp);
    }

    /**
     * Retrieves the car_serialized property from the properties file.
     * @return the car_serialized property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getCarSerializeFile() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(carSerializeFile);
    }

    /**
     * Retrieves the bicycle_serialized property from the properties file.
     * @return the bicycle_serialized property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getBicycleSerializeFile() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(bicycleSerializeFile);
    }

    /**
     * Retrieves the scooter_serialized property from the properties file.
     * @return the scooter_serialized property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getScooterSerializeFile() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(scooterSerializeFile);
    }

    /**
     * Retrieves the car_income_serialized property from the properties file.
     * @return the car_income_serialized property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getCarIncomeSerializeFile() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(carIncomeSerializeFile);
    }

    /**
     * Retrieves the bicycle_income_serialized property from the properties file.
     * @return the bicycle_income_serialized property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getBicycleIncomeSerializeFile() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(bicycleIncomeSerializeFile);
    }

    /**
     * Retrieves the scooter_income_serialized property from the properties file.
     * @return the scooter_income_serialized property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getScooterIncomeSerializeFile() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(scooterIncomeSerializeFile);
    }

    /**
     * Retrieves the rents_file property from the properties file.
     * @return the rents_file property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getRentsFile() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(rentsFile);
    }

    /**
     * Retrieves the vehicles_file property from the properties file.
     * @return the vehicles_file property
     * @throws IOException if an I/O error occurs while loading the properties
     */
    public static String getVehiclesFile() throws IOException {
        Properties properties = loadProperties();
        return properties.getProperty(vehiclesFile);
    }
}
