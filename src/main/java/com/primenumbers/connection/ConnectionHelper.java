package com.primenumbers.connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primenumbers.dto.*;
import com.primenumbers.dto.AddressDto;
import com.primenumbers.dto.BodyStyleDto;
import com.primenumbers.dto.InsuranceDto;
import com.primenumbers.dto.OwnerDto;
import com.primenumbers.dto.VehicleDto;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ConnectionHelper {
    private final ObjectMapper objectMapper;
    private final ConnectionBean connectionBean;
    private final String TAG = "ConnectionHelper";
    public ConnectionHelper(){
        objectMapper = new ObjectMapper();
        //connectionBean = new ConnectionBean("http://127.0.0.1:8080/study");
        connectionBean = new ConnectionBean("http://127.0.0.1:8000/study");
    }

    public void saveInsurances(List<InsuranceDto> insurances) throws IOException {
        connectionBean.postObjects(insurances, "/insurance/saveInsurances");
    }

    public void saveOwners(List<OwnerDto> ownerDtos) throws IOException {
        connectionBean.postObjects(ownerDtos, "/owners/saveOwners");
    }

    public void saveAddresses(List<AddressDto> addressDtos) throws IOException {
        connectionBean.postObjects(addressDtos, "/address/saveAddresses");
    }

    public void saveBodyStyles(List<BodyStyleDto> bodyStyleDtos) throws IOException {
        connectionBean.postObjects(bodyStyleDtos, "/bodystyle/saveBodyStyles");
    }

    public void saveVehicles(List<VehicleDto> vehicleDtos) throws IOException{
        connectionBean.postObjects(vehicleDtos, "/vehicles/saveVehicles");
    }

    public void saveColours(List<ColourDto> colourDtos) throws IOException {
        connectionBean.postObjects(colourDtos, "/colour/saveColours");
    }

    public void saveInsuranceTypes(List<InsuranceTypeDto> insuranceTypeDtos) throws IOException {
        connectionBean.postObjects(insuranceTypeDtos, "/insurancetype/saveInsurances");
    }

    public void saveOwnedVehicles(List<OwnedVehicleDto> ownedVehicleDtos) throws IOException {
        connectionBean.postObjects(ownedVehicleDtos, "/ownedvehicles/saveOwnedVehicles");
    }

    public void updateOwnedVehicles(int amount) throws IOException {
        connectionBean.postObject(null, "/ownedvehicles/updateOwnedVehicles/11/11/1/" + amount);
    }

    public void deleteAllInsurances() throws IOException {
        connectionBean.deleteObjects("/insurance/deleteAll");
    }

    public void deleteAllInsuranceTypes() throws IOException {
        connectionBean.deleteObjects("/insurancetype/deleteAll");
    }

    public void deleteAllOwners() throws IOException {
        connectionBean.deleteObjects("/owners/deleteAll");
    }

    public void deleteAllAddresses() throws IOException {
        connectionBean.deleteObjects("/address/deleteAll");
    }

    public void deleteAllBodyStyles() throws IOException{
        connectionBean.deleteObjects("/bodystyle/deleteAll");
    }

    public void deleteAllOwnedVehicles() throws IOException {
        connectionBean.deleteObjects("/ownedvehicles/deleteAll");
    }

    public void deleteAllColours() throws IOException{
        connectionBean.deleteObjects("/colour/deleteAll");
    }

    public void deleteAllVehicles() throws IOException{
        connectionBean.deleteObjects("/vehicles/deleteAll");
    }

    public String findAllOwnedVehicles() throws IOException{
        return connectionBean.getData("/ownedvehicles/get");
    }

    public void updateInsurances(int amount, LocalDate nextDate) throws IOException{
        Date startDate = Date.valueOf(nextDate);
        Date expirationDate = Date.valueOf(nextDate.plusDays(1));
        InsuranceDto insuranceDto = InsuranceDto.builder().id(1L).startDate(startDate).expiration(expirationDate).fkOwnedVehicleId(1L).fkTypeId(1L).build();
        connectionBean.postObject(insuranceDto, "/insurance/updateInsurance/1/"+ amount);
    }

    public String findAll() throws IOException{
        return connectionBean.getData("/insurance/get");
    }

    public String selectWithJoin() throws IOException {
        return connectionBean.getData("/ownedvehicles/selectWithJoin");
    }

}
