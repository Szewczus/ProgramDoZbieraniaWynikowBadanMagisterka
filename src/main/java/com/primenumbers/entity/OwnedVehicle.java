package com.primenumbers.entity;


import java.util.Date;
import java.util.Set;

public class OwnedVehicle {
    private Long id;
    private Owner fkOwner;
    private Vehicle fkVehicle;
    private Date productionDate;
    private BodyStyle fkBodyStyle;
    private Colour fkColour;

    private Set<Insurance> insurances;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Owner getFkOwner() {
        return fkOwner;
    }

    public void setFkOwner(Owner fkOwner) {
        this.fkOwner = fkOwner;
    }

    public Vehicle getFkVehicle() {
        return fkVehicle;
    }

    public void setFkVehicle(Vehicle fkVehicle) {
        this.fkVehicle = fkVehicle;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public BodyStyle getFkBodyStyle() {
        return fkBodyStyle;
    }

    public void setFkBodyStyle(BodyStyle fkBodyStyle) {
        this.fkBodyStyle = fkBodyStyle;
    }

    public Colour getFkColour() {
        return fkColour;
    }

    public void setFkColour(Colour fkColour) {
        this.fkColour = fkColour;
    }
}
