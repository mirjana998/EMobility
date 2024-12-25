package com.example.epj2.model.electricvehicle;

import com.example.epj2.controller.MainWindowController;
import com.example.epj2.model.Configuration;
import com.example.epj2.model.rent.Rent;
import com.example.epj2.model.rent.User;
import javafx.scene.image.Image;

import java.io.*;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * Represents an electric vehicle.
 * This class provides methods to access and manipulate electric vehicle attributes.
 */
public abstract class ElectricVehicle extends Thread implements Serializable{
    private String id;
    private double price;
    private String manufacturer;
    private String model;
    private int batteryLevel;
    transient private Image image;
    private boolean rideFinished;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private long fieldStay;
    private static int vehicleCounter = 0;
    private static int listNumber = 0;

    /**
     * Gets the image of the electric vehicle.
     * @return the image of the electric vehicle
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets new image of the electric vehicle.
     * @param image the new image of the electric vehicle
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Gets the identifier of the electric vehicle.
     * @return the identifier of the electric vehicle
     */
    public String getVehicleId() {
        return id;
    }

    /**
     * Gets the manufacturer of the electric vehicle.
     * @return the manufacturer of the electric vehicle
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Gets the model of the electric vehicle.
     * @return the model of the electric vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets new model of the electric vehicle.
     * @param model the new model of the electric vehicle
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the battery level of the electric vehicle.
     * @return the battery level of the electric vehicle
     */
    public int getBatteryLevel() {
        return batteryLevel;
    }

    /**
     * Sets new price of the electric vehicle.
     * @param price the new price of the electric vehicle
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the price of the electric vehicle.
     * @return the price of the electric vehicle
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the starting position of the current vehicle rent on x-axis.
     * @return the starting position of the current vehicle rent on x-axis
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Sets new starting position of the current vehicle rent on x-axis.
     * @param startX the new starting position of the current vehicle rent on x-axis
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * Gets the starting position of the current vehicle rent on y-axis.
     * @return the starting position of the current vehicle rent on y-axis
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Sets new starting position of the current vehicle rent on y-axis.
     * @param startY the new starting position of the current vehicle rent on y-axis
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * Gets the ending position of the current vehicle rent on x-axis.
     * @return the ending position of the current vehicle rent on x-axis
     */
    public int getEndX() {
        return endX;
    }

    /**
     * Sets new ending position of the current vehicle rent on x-axis.
     * @param endX the new ending position of the current vehicle rent on x-axis
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * Gets the ending position of the current vehicle rent on y-axis.
     * @return the ending position of the current vehicle rent on x-axis
     */
    public int getEndY() {
        return endY;
    }

    /**
     * Sets new ending position of the current vehicle rent on y-axis.
     * @param endY the new ending position of the current vehicle rent on y-axis
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * Decreases the value of battery level by five.
     */
    public void batteryDischarge() {
        batteryLevel-=5;
    }

    /**
     * Sets the value of the battery level to 100.
     */
    public void batteryCharge() {batteryLevel=100;}

    public ElectricVehicle() {
    }

    /**
     * Constructs new ElectricVehicle object.
     * @param id the identifier of the electric vehicle
     * @param price the price of the electric vehicle
     * @param manufacturer the manufacturer of the electric vehicle
     * @param model the model of the electric vehicle
     * @param batteryLevel the battery level of the electric vehicle
     */
    public ElectricVehicle(String id,double price, String manufacturer, String model, int batteryLevel) {
        this.id = id;
        this.price = price;
        this.manufacturer = manufacturer;
        this.model = model;
        this.batteryLevel = batteryLevel;
        this.rideFinished = false;
    }

    /**
     * Constructs a new ElectricVehicle object with attributes of electricVehicle parameter.
     * @param electricVehicle the ElectricVehicle object on the basis of which a new one will be made
     */
    public ElectricVehicle(ElectricVehicle electricVehicle) {
        this.id = electricVehicle.getVehicleId();
        this.price = electricVehicle.getPrice();
        this.manufacturer = electricVehicle.getManufacturer();
        this.model = electricVehicle.getModel();
        this.batteryLevel = electricVehicle.getBatteryLevel();
        this.rideFinished = false;
    }

    /**
     * Loads an image from the specified file and sets it to the UI.
     * @param imageFile the filename of the image to load, this parameter can be null
     * @throws IOException if an error occurs while reading the image file.
     */
    public void InitializeImage(String imageFile) throws IOException{
        this.setImage(new Image(new BufferedInputStream(new FileInputStream(new File(Paths.get(Configuration.getUserDirProp() + File.separator + Configuration.getPicturePathProp() + File.separator + imageFile).toUri())))));
    }

    /**
     * Calculates the time the vehicle stays on one city map field during the ride.
     * @param duration duration of the rent of the electric vehicle
     */
    public void calculateFieldStay(int duration) {
        double numberOfFields = Math.abs(endX-startX) + Math.abs(endY-startY);
        fieldStay = (long)((duration/numberOfFields)*1000);
    }


    /**
     * Simulates the movement of a vehicle on a city map within the main window.
     */
    @Override
    public void run() {
        addVehicleToCityMap();
        MainWindowController.addPaneToGrid(this);
        //long startingTime = System.currentTimeMillis();
        try {
            this.sleep(500);
        }catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        while(!rideFinished) {
            if(startX==endX && startY==endY) {
                rideFinished = true;
                //ridingTime = (System.currentTimeMillis() - startingTime);
            }
            while(startX!=endX) {
                if (startX < endX) {
                    MainWindowController.removeFromPane(this, true,false);
                    MainWindowController.cityMap[startX][startY].getVehicleList().remove(this);
                    //startX++;
                    addVehicleToCityMap();
                    MainWindowController.addPaneToGrid(this);
                    try {
                        this.sleep(fieldStay);
                    }catch(InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
                //startX > endX
                else {
                    MainWindowController.removeFromPane(this,false,false);
                    MainWindowController.cityMap[startX][startY].getVehicleList().remove(this);
                    //startX--;
                    addVehicleToCityMap();
                    MainWindowController.addPaneToGrid(this);
                    try {
                        this.sleep(fieldStay);
                    }catch(InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }
            while(startY!=endY) {
                if(startY<endY) {
                    MainWindowController.removeFromPane(this, false, true);
                    MainWindowController.cityMap[startX][startY].getVehicleList().remove(this);
                    //startY++;
                    addVehicleToCityMap();
                    MainWindowController.addPaneToGrid(this);
                    try {
                        this.sleep(fieldStay);
                    }catch(InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
                else{
                    MainWindowController.removeFromPane(this, true, true);
                    MainWindowController.cityMap[startX][startY].getVehicleList().remove(this);
                    //startY--;
                    addVehicleToCityMap();
                    MainWindowController.addPaneToGrid(this);
                    try {
                        this.sleep(fieldStay);
                    }catch(InterruptedException exception) {
                        exception.printStackTrace();
                    }
                    /*
                    synchronized (System.out) {
                        System.out.println("Vehicle " + getVehicleId() + " is at position (" + startX + "," +startY + ")");
                    }*/
                }
            }
        }
        vehicleCounter++;
        generateInvoice();
        batteryCharge();
        //if all vehicles of currentRent list finished their ride
        if(vehicleCounter == MainWindowController.currentVehicles.size()){
            try {
                listNumber++; //increases the ordinal number of currentRent list
                sleep(5000);
                MainWindowController.clearAllFields();
                MainWindowController.clearAllPanes();
                vehicleCounter = 0;
                if(listNumber<=MainWindowController.rentsGroupedByDateTime.size()) {
                    MainWindowController.runVehicles(listNumber);
                }
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
    }

    private void addVehicleToCityMap() {
        MainWindowController.cityMap[startX][startY].getVehicleList().add(this);
        Optional<Rent> optionalRent = MainWindowController.currentRents.stream().filter(rent -> rent.getVehicleId().equals(this.id)).findFirst();
        if(optionalRent.isPresent()) {
            Rent rent = optionalRent.get();
            if (MainWindowController.cityMap[startX][startY].isOuterCityArea()) {
                rent.setDistanceWideRate(true);
            }
        }
    }

    //generates invoice and add malfunction if there is any
    private void generateInvoice() {
        Optional<Rent> optionalRent = MainWindowController.currentRents.stream().filter(rent -> rent.getVehicleId().equals(this.id)).findFirst();
        if(optionalRent.isPresent()) {
            Rent rent = optionalRent.get();
            if(rent.isHasMalfunction()) {
                Malfunction malfunction = new Malfunction(rent.getDateTime(),this.id);
                malfunction.updateVehicleType(this);
                MainWindowController.malfunctionList.add(malfunction);
            }
            rent.calculateFinalPrice();
            Optional<User> optionalUser = MainWindowController.userList.stream().filter(user -> user.getUsername().equals(rent.getUser())).findFirst();
            if(optionalUser.isPresent()) {
                User user = optionalUser.get();
                try {
                    BufferedWriter bf = new BufferedWriter(new FileWriter(new File(Paths.get(Configuration.getUserDirProp() + File.separator + Configuration.getInvoicePathProp() + File.separator + "rent" + rent.getId() + "Invoice.txt").toUri())));
                    bf.write("Date-time: " + rent.getDateTime());
                    bf.newLine();
                    bf.write("Rent id: " + rent.getId());
                    bf.newLine();
                    bf.write("Rent coordinates: from (" + rent.getStartX() + "," + rent.getStartY() + ") to (" + rent.getEndX() + "," +  rent.getEndY() + ")");
                    bf.newLine();
                    bf.write("Vehicle id: " + rent.getVehicleId());
                    bf.newLine();
                    bf.write("User ID: " + (user.isForeigner()?user.getPassport():user.getIdCard()));
                    bf.newLine();
                    bf.write("User Driver Licence: " + user.getDriversLicenceNumber());
                    bf.newLine();
                    bf.write("Driving time[s]: " + rent.getDuration());
                    bf.newLine();
                    bf.write("Primary price: "+ rent.getPrimaryPrice());
                    bf.newLine();
                    bf.write("Distance: "+ rent.getDistance());
                    bf.newLine();
                    bf.write("Promotion: "+ rent.getPromotion());
                    bf.newLine();
                    bf.write("Discount: "+ rent.getDiscount());
                    bf.newLine();
                    bf.write("Malfunction: "+ rent.isHasMalfunction());
                    bf.newLine();
                    bf.write("TOTAL: "+ rent.getFinalPrice());
                    bf.close();
                }catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }


    /**
     * Returns the string representation of ElectricVehicle object.
     * @return the string representation of the electric vehicle
     */
    @Override
    public String toString() {
        return "Vehicle id: " + id + "\nprice: " + price + "\nmanufacturer: " + manufacturer + "\nmodel: " + model + "\nbattery level: " + batteryLevel + "\nstartX: " + startX + "\nstartY: " + startY + "\nendX: " + endX + "\nendY: " + endY + "\nfieldStay: " + fieldStay;
    }
}
