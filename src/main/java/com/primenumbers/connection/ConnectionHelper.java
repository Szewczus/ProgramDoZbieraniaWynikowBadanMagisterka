package com.primenumbers.connection;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.primenumbers.dto.*;
import com.primenumbers.dto.AddressDto;
import com.primenumbers.dto.BodyStyleDto;
import com.primenumbers.dto.InsuranceDto;
import com.primenumbers.dto.OwnerDto;
import com.primenumbers.dto.VehicleDto;
import com.primenumbers.entity.Insurance;
import com.primenumbers.entity.Owner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.zip.InflaterOutputStream;

public class ConnectionHelper {
    private final ObjectMapper objectMapper;
    private final ConnectionBean connectionBean;
    private final String TAG = "ConnectionHelper";
    public ConnectionHelper(){
        objectMapper = new ObjectMapper();
        connectionBean = new ConnectionBean("http://127.0.0.1:8080/study");
    }


    public void saveInsurances(List<InsuranceDto> insurances) throws IOException {
        System.out.println("saveInsurances");
        connectionBean.postObjects(insurances, "/insurance/saveInsurances");
    }

    public void saveOwners(List<OwnerDto> ownerDtos) throws IOException {
        System.out.println("saveOwners");
        connectionBean.postObjects(ownerDtos, "/owners/saveOwners");
    }

    public void saveAddresses(List<AddressDto> addressDtos) throws IOException {
        System.out.println("saveAddresses");
        connectionBean.postObjects(addressDtos, "/address/saveAdresses");
    }

    public void saveBodyStyles(List<BodyStyleDto> bodyStyleDtos) throws IOException {
        System.out.println("saveBodyStyles");
        connectionBean.postObjects(bodyStyleDtos, "/bodystyle/saveBodyStyles");
    }

    public void saveVehicles(List<VehicleDto> vehicleDtos) throws IOException{
        System.out.println("saveVehicles");
        connectionBean.postObjects(vehicleDtos, "/vehicles/saveVehicles");
    }

    public void saveColours(List<ColourDto> colourDtos) throws IOException {
        System.out.println("saveColours");
        connectionBean.postObjects(colourDtos, "/colour/saveColours");
    }

    public void saveInsuranceTypes(List<InsuranceTypeDto> insuranceTypeDtos) throws IOException {
        System.out.println("saveInsuranceTypes");
        connectionBean.postObjects(insuranceTypeDtos, "/insurancetype/saveInsurances");
    }

    public void saveOwnedVehicles(List<OwnedVehicleDto> ownedVehicleDtos) throws IOException {
        System.out.println("saveOwnedVehicles");
        connectionBean.postObjects(ownedVehicleDtos, "/ownedvehicles/saveOwnedVehicles");
    }

    public void updateOwnedVehicles(int amount) throws IOException {
        connectionBean.postObject(null, "/ownedvehicles/updateOwnedVehicles/11/11/1/" + amount);
    }
}
