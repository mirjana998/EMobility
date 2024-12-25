package com.example.epj2.model.map;

import com.example.epj2.model.electricvehicle.ElectricVehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the field of the city map matrix where vehicles can be placed.
 * This class provides methods to access and manipulate field attributes.
 */
public class Field {
    private List<ElectricVehicle> vehicleList = new ArrayList<>();
    private boolean outerArea;

    /**
     * Constructs a new Field object.
     */
    public Field() {
        this.outerArea = true;
    }

    /**
     *  Gets the list of vehicles located at the field.
     * @return the list of vehicles located at the field
     */
    public List<ElectricVehicle> getVehicleList() {
        return vehicleList;
    }

    /**
     *  Gets the value of the attribute that indicates if the field is part of outer city area.
     * @return {@code true} if the field is part of outer city area, {@code false} otherwise
     */
    public boolean isOuterCityArea() {
        return outerArea;
    }

    /**
     * Sets new value of the attribute that indicates if the field is part of outer city area.
     * @param outerArea {@code true} if the field is part of outer city area, {@code false} otherwise
     */
    public void setOuterArea(boolean outerArea) {
        this.outerArea = outerArea;
    }
}
