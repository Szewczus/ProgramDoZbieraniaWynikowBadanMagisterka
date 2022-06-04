package com.primenumbers.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VehicleDto {
    private Long id;
    private String brand;
    private String model;
}
