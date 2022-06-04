package com.primenumbers;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.controller.BodyStyleController;
import com.primenumbers.controller.ColourController;
import com.primenumbers.controller.OwnedVehicleController;
import com.primenumbers.controller.VehicleController;
import com.primenumbers.dto.InsuranceDto;
import com.primenumbers.dto.VehicleDto;

import com.primenumbers.controller.*;

public class Main {

    public static void main(String[] args) {
        VehicleController vehicleController = new VehicleController();
        ColourController colourController = new ColourController();
        BodyStyleController bodyStyleController = new BodyStyleController();
        InsuranceTypeController insuranceTypeController = new InsuranceTypeController();
        OwnerController ownerController = new OwnerController();
        AddressController addressController = new AddressController();
        OwnedVehicleController ownedVehicleController = new OwnedVehicleController();
        InsuranceController insuranceController = new InsuranceController();


        vehicleController.save();
        colourController.save();
        bodyStyleController.save();
        insuranceTypeController.save();
        ownerController.save();
        addressController.save();
        ownedVehicleController.save(100);
        insuranceController.save(100);

    }


    void ownedVehicle100(){
        OwnedVehicleController ownedVehicleController = new OwnedVehicleController();
        System.out.println();
        try {
            ownedVehicleController.save(100);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
