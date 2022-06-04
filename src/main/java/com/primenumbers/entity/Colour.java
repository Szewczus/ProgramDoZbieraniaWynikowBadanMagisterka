package com.primenumbers.entity;

import java.util.Set;

public class Colour {
    private Long id;
    private String carColour;

    private Set<OwnedVehicle> ownedVehicles;

    public Colour() {

    }

    public Colour(Long id, String carColour,  Set<OwnedVehicle> ownedVehicles) {
        this.id = id;
        this.carColour = carColour;
        this.ownedVehicles = ownedVehicles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String colour) {
        this.carColour = colour;
    }
}
