package com.primenumbers.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BodyStyle {
    private Long id;
    private String style;
    private Integer doorNumber;
    private Set<OwnedVehicle> ownedVehicles;
}