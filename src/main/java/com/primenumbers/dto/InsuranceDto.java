package com.primenumbers.dto;

import lombok.Builder;

import java.util.Date;
@Builder
public class InsuranceDto {
    private Long id;
    private Long fkOwnedVehicleId;
    private Date startDate;
    private Date expiration;
    private Long fkTypeId;
}
