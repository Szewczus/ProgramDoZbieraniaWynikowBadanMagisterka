package com.primenumbers.entity;


import java.util.Set;

public class BodyStyle {
    private Long id;
    private String style;
    private Integer doorNumber;
    private Set<OwnedVehicle> ownedVehicles;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public Integer getDoorNumber() {
        return doorNumber;
    }
    public void setDoorNumber(Integer doorNumber) {
        this.doorNumber = doorNumber;
    }
}
