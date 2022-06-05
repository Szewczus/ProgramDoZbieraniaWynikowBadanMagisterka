package com.primenumbers.controller;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.dto.InsuranceTypeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InsuranceTypeController {
    private Logger log = LoggerFactory.getLogger(InsuranceTypeController.class);

    private List<InsuranceTypeDto> generate(){
        List<InsuranceTypeDto> insuranceTypeDtos = new ArrayList<>();
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(1L).type("OC").cost("420").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(2L).type("OC").cost("350").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(3L).type("OC").cost("475").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(4L).type("OC").cost("400").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(5L).type("OC").cost("450").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(6L).type("AC").cost("410").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(7L).type("AC").cost("420").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(8L).type("AC").cost("430").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(9L).type("AC").cost("440").build());
        insuranceTypeDtos.add(InsuranceTypeDto.builder().id(10L).type("AC").cost("450").build());
        return insuranceTypeDtos;
    }

    public void save() {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.saveInsuranceTypes(generate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll(){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.deleteAllInsuranceTypes();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
