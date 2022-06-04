package com.primenumbers.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Insurance {
    private Long id;
    private OwnedVehicle fkOwnedVehicle;
    private Date startDate;
    private Date expiration;
    private InsuranceType fkType;
}
