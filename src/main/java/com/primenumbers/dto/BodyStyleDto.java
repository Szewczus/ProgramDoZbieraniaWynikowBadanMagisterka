package com.primenumbers.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BodyStyleDto {
    private Long id;
    private String style;
    private Integer doorNumber;
}
