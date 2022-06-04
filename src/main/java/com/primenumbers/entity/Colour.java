package com.primenumbers.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Colour {
    private Long id;
    private String carColour;
    private Set<OwnedVehicle> ownedVehicles;
}
