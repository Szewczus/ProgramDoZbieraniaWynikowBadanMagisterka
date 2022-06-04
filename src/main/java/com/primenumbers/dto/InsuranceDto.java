package com.primenumbers.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Builder
@Getter
@Setter
public class InsuranceDto {
    private Long id;
    private Long fkOwnedVehicleId;
    private Date startDate;
    private Date expiration;
    private Long fkTypeId;


}
