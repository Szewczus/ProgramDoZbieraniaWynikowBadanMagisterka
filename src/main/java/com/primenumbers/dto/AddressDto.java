package com.primenumbers.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressDto {
    private Long id;
    private String postalCode;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;
    private Long fkOwnerId;
}
