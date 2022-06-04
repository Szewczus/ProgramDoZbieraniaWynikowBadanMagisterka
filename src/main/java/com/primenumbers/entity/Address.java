package com.primenumbers.entity;


public class Address {
    private Long id;
    private String postalCode;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;
    private Owner fkOwner;
}
