package com.primenumbers.dto;


import java.util.Date;
public class OwnedVehicleDto {
    private Long id;
    private Long fkOwnerId;
    private Long fkVehicleId;
    private Date productionDate;
    private Long fkBodyStyleId;
    private Long fkColourId;

}
