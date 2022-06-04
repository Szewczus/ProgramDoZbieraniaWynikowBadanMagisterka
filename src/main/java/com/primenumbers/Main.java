package com.primenumbers;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.controller.BodyStyleController;
import com.primenumbers.controller.ColourController;
import com.primenumbers.controller.OwnedVehicleController;
import com.primenumbers.controller.VehicleController;
import com.primenumbers.dto.InsuranceDto;
import com.primenumbers.dto.VehicleDto;

import com.primenumbers.controller.*;
import com.primenumbers.invokers.InsurancesInvoker;
import com.primenumbers.invokers.OwnedVehicleInvoker;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.fillDatabase();
        main.insurances();
        main.ownedVehicles();

    }

    private void fillDatabase() {
        System.out.println("Fill database");
        VehicleController vehicleController = new VehicleController();
        ColourController colourController = new ColourController();
        BodyStyleController bodyStyleController = new BodyStyleController();
        InsuranceTypeController insuranceTypeController = new InsuranceTypeController();
        OwnerController ownerController = new OwnerController();
        AddressController addressController = new AddressController();
        OwnedVehicleController ownedVehicleController = new OwnedVehicleController();
        InsuranceController insuranceController = new InsuranceController();

        System.out.println("Save vehicle...");
        vehicleController.save();

        System.out.println("Save colour...");
        colourController.save();

        System.out.println("Save bodyStyle...");
        bodyStyleController.save();

        System.out.println("Save insuranceType...");
        insuranceTypeController.save();

        System.out.println("Save owner...");
        ownerController.save();

        System.out.println("Save address...");
        addressController.save();

        System.out.println("Save ownedVehicle...");
        ownedVehicleController.save(100);

        System.out.println("Save insurance...");
        insuranceController.save(100);
    }

    public void insurances() {
        InsurancesInvoker insurancesInvoker = new InsurancesInvoker();
        insurancesInvoker.insuranceTest(100);
        //insurancesInvoker.insuranceTest(1000);
        //insurancesInvoker.insuranceTest(10000);
    }


    public void ownedVehicles(){
        System.out.println("--------------");
        OwnedVehicleInvoker ownedVehicleInvoker = new OwnedVehicleInvoker();
        ownedVehicleInvoker.saveOwnedVehicles100();
        //ownedVehicleInvoker.saveOwnedVehicles1000();
        //ownedVehicleInvoker.saveOwnedVehicles10000();

    }


}
