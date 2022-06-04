package com.primenumbers.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Builder
public class OwnedVehicleDto {
    private Long id;
    private Long fkOwnerId;
    private Long fkVehicleId;
    private Date productionDate;
    private Long fkBodyStyleId;
    private Long fkColourId;

}
