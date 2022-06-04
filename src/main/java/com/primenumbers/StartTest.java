package com.primenumbers;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.dto.InsuranceDto;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StartTest {

    public StartTest() {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.saveInsurances(generate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<InsuranceDto> generate() {
        List<InsuranceDto> insuranceDtos = new ArrayList<>();
        insuranceDtos.add(InsuranceDto.builder().id(1L).startDate(Date.valueOf("2010-01-01")).expiration(Date.valueOf("2011-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(2L).startDate(Date.valueOf("2011-01-01")).expiration(Date.valueOf("2012-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(4L).startDate(Date.valueOf("2013-01-01")).expiration(Date.valueOf("2014-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(5L).startDate(Date.valueOf("2014-01-01")).expiration(Date.valueOf("2015-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(6L).startDate(Date.valueOf("2015-01-01")).expiration(Date.valueOf("2016-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(7L).startDate(Date.valueOf("2016-01-01")).expiration(Date.valueOf("2017-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(3L).startDate(Date.valueOf("2012-01-01")).expiration(Date.valueOf("2013-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(8L).startDate(Date.valueOf("2017-01-01")).expiration(Date.valueOf("2018-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(9L).startDate(Date.valueOf("2018-01-01")).expiration(Date.valueOf("2019-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());
        insuranceDtos.add(InsuranceDto.builder().id(10L).startDate(Date.valueOf("2019-01-01")).expiration(Date.valueOf("2020-01-01")).fkTypeId(1L).fkOwnedVehicleId(1L).build());

        return insuranceDtos;
    }


}
