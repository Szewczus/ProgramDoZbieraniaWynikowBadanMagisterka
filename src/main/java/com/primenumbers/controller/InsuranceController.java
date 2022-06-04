package com.primenumbers.controller;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.dto.InsuranceDto;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InsuranceController {

    private void saveInsurances(){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.saveInsurances(generateDefinedAmountInsurances(100));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<InsuranceDto> generateDefinedAmountInsurances(int amount) {
        List<InsuranceDto> dtos = new ArrayList<>();
        LocalDate localDate = LocalDate.of(2000, 1, 1);

        for(int i = 1; i <=amount; i++) {
            long fkValue = Long.valueOf(i%10 == 0 ? 10 : i%10);
            dtos.add(InsuranceDto.builder().id(Long.valueOf(i)).startDate(Date.valueOf(localDate)).expiration(Date.valueOf(localDate.plusDays(1))).fkTypeId(fkValue).fkOwnedVehicleId(fkValue).build());
            localDate = localDate.plusDays(1);
        }
        return dtos;
    }
}
