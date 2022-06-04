package com.primenumbers.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ColourDto {
    private Long id;
    private String carColour;
}
