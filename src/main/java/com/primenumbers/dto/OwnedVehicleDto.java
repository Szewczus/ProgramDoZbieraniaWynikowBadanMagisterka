package com.primenumbers.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date productionDate;
    private Long fkBodyStyleId;
    private Long fkColourId;

}
