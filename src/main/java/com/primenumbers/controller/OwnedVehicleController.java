package com.primenumbers.controller;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.dto.OwnedVehicleDto;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OwnedVehicleController {
    private List<OwnedVehicleDto> generate() {
        List<OwnedVehicleDto> dtos = new ArrayList<>();
        dtos.add(OwnedVehicleDto.builder().id(1L).fkOwnerId(1L).fkVehicleId(1L).productionDate(Date.valueOf("2020-12-12")).fkBodyStyleId(1L).fkColourId(1L).build());
        dtos.add(OwnedVehicleDto.builder().id(2L).fkOwnerId(2L).fkVehicleId(2L).productionDate(Date.valueOf("2019-01-01")).fkBodyStyleId(2L).fkColourId(2L).build());
        dtos.add(OwnedVehicleDto.builder().id(3L).fkOwnerId(3L).fkVehicleId(3L).productionDate(Date.valueOf("2018-02-02")).fkBodyStyleId(3L).fkColourId(3L).build());
        dtos.add(OwnedVehicleDto.builder().id(4L).fkOwnerId(4L).fkVehicleId(4L).productionDate(Date.valueOf("2017-03-03")).fkBodyStyleId(4L).fkColourId(4L).build());
        dtos.add(OwnedVehicleDto.builder().id(5L).fkOwnerId(5L).fkVehicleId(5L).productionDate(Date.valueOf("2016-04-04")).fkBodyStyleId(5L).fkColourId(5L).build());
        dtos.add(OwnedVehicleDto.builder().id(6L).fkOwnerId(6L).fkVehicleId(6L).productionDate(Date.valueOf("2015-05-05")).fkBodyStyleId(6L).fkColourId(6L).build());
        dtos.add(OwnedVehicleDto.builder().id(7L).fkOwnerId(7L).fkVehicleId(7L).productionDate(Date.valueOf("2014-06-06")).fkBodyStyleId(7L).fkColourId(7L).build());
        dtos.add(OwnedVehicleDto.builder().id(8L).fkOwnerId(8L).fkVehicleId(8L).productionDate(Date.valueOf("2013-07-07")).fkBodyStyleId(8L).fkColourId(8L).build());
        dtos.add(OwnedVehicleDto.builder().id(9L).fkOwnerId(9L).fkVehicleId(9L).productionDate(Date.valueOf("2012-08-08")).fkBodyStyleId(9L).fkColourId(9L).build());
        dtos.add(OwnedVehicleDto.builder().id(10L).fkOwnerId(10L).fkVehicleId(10L).productionDate(Date.valueOf("2011-09-09")).fkBodyStyleId(10L).fkColourId(10L).build());
        return dtos;
    }

    private List<OwnedVehicleDto> generateDefinedAmount(int amount) {
        List<OwnedVehicleDto> dtos = new ArrayList<>();
        LocalDate localDate = LocalDate.of(2000, 1, 1);

        for(int i = 1; i <=amount; i++) {
            long fkValue = Long.valueOf(i%10 == 0 ? 10 : i%10);
            dtos.add(OwnedVehicleDto.builder().id(Long.valueOf(i)).fkOwnerId(fkValue).fkVehicleId(fkValue).productionDate(Date.valueOf(localDate)).fkBodyStyleId(fkValue).fkColourId(fkValue).build());
            localDate = localDate.plusDays(1);
        }
        return dtos;
    }

    public void save(int amount){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.saveOwnedVehicles(generateDefinedAmount(amount));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(int amount) {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.updateOwnedVehicles(amount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.deleteOwnedVehicles();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
