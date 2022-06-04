package com.primenumbers;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.controller.BodyStyleController;
import com.primenumbers.controller.ColourController;
import com.primenumbers.controller.OwnedVehicleController;
import com.primenumbers.controller.VehicleController;
import com.primenumbers.dto.InsuranceDto;
import com.primenumbers.dto.VehicleDto;

import com.primenumbers.controller.*;
import com.primenumbers.invokers.OwnedVehicleInvoker;

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

        Main main = new Main();
        main.ownedVehicles();

    }


    public void ownedVehicles(){
        System.out.println("--------------");
        OwnedVehicleInvoker ownedVehicleInvoker = new OwnedVehicleInvoker();
        ownedVehicleInvoker.saveOwnedVehicles100();
        //ownedVehicleInvoker.saveOwnedVehicles1000();
        //ownedVehicleInvoker.saveOwnedVehicles10000();

    }


}
