package com.primenumbers.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InsuranceTypeDto {
    private Long id;
    private String type;
    private String cost;
}
