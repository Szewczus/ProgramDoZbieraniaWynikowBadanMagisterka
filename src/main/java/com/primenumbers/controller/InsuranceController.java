package com.primenumbers.controller;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.dto.InsuranceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InsuranceController {
    private Logger log = LoggerFactory.getLogger(InsuranceController.class);
    public void save(int amount){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.saveInsurances(generateDefinedAmountInsurances(amount));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public void update(int amount, LocalDate nextDate){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try{
            connectionHelper.updateInsurances(amount, nextDate);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void deleteAll(){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try{
            connectionHelper.deleteAll();
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public String findAll(){
        ConnectionHelper connectionHelper= new ConnectionHelper();
        try {
            return connectionHelper.findAll();
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
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
