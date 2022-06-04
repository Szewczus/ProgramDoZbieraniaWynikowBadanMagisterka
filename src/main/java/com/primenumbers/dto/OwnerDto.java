package com.primenumbers.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class OwnerDto {
    private Long id;
    private String name;
    private String surname;
    private Date birthdate;
    private Long pesel;
}
