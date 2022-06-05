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

    private VehicleController vehicleController;
    private ColourController colourController;
    private BodyStyleController bodyStyleController;
    private InsuranceTypeController insuranceTypeController;
    private OwnerController ownerController;
    private AddressController addressController;
    private OwnedVehicleController ownedVehicleController;
    private InsuranceController insuranceController;

    public Main() {
        vehicleController = new VehicleController();
        colourController = new ColourController();
        bodyStyleController = new BodyStyleController();
        insuranceTypeController = new InsuranceTypeController();
        ownerController = new OwnerController();
        addressController = new AddressController();
        ownedVehicleController = new OwnedVehicleController();
        insuranceController = new InsuranceController();
    }

    public static void main(String[] args) {

        Main main = new Main();

        main.clearDatabase();
        main.fillDatabase();
        main.insurances();
        main.ownedVehicles();

    }

    private void clearDatabase(){
        System.out.println("CLEAR DATABASE");

        System.out.println("Clear insurance...");
        insuranceController.deleteAll();

        System.out.println("Clear ownedVehicle...");
        ownedVehicleController.delete();

        System.out.println("Clear address...");
        addressController.deleteAll();

        System.out.println("Clear insuranceType...");
        insuranceTypeController.deleteAll();

        System.out.println("Clear owner...");
        ownerController.deleteAll();

        System.out.println("Clear vehicle...");
        vehicleController.deleteAll();

        System.out.println("Clear colour...");
        colourController.deleteAll();

        System.out.println("Clear bodyStyle...");
        bodyStyleController.deleteAll();
    }

    private void fillDatabase() {
        System.out.println("FILL DATABASE");


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
        insurancesInvoker.insuranceTest(1000);
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
