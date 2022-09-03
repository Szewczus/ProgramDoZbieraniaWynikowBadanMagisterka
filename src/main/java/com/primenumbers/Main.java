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

        main.clearDatabase(true);
        //main.fillDatabase();
        //main.insurances();
        main.ownedVehicles();

    }

    public void clearDatabase(boolean showLogs){
        if(showLogs){
            System.out.println("CLEAR DATABASE");
        }

        if(showLogs){
            System.out.println("Clear insurance...");
        }
        insuranceController.deleteAll();

        if(showLogs){
            System.out.println("Clear ownedVehicle...");
        }
        ownedVehicleController.delete();

        if(showLogs){
            System.out.println("Clear address...");
        }
        addressController.deleteAll();

        if(showLogs){
            System.out.println("Clear insuranceType...");
        }
        insuranceTypeController.deleteAll();

        if(showLogs){
            System.out.println("Clear owner...");
        }
        ownerController.deleteAll();

        if(showLogs){
            System.out.println("Clear vehicle...");
        }
        vehicleController.deleteAll();

        if(showLogs){
            System.out.println("Clear colour...");
        }
        colourController.deleteAll();

        if(showLogs){
            System.out.println("Clear bodyStyle...");
        }
        bodyStyleController.deleteAll();
    }

    public void fillDatabase(boolean showLogs) {
        if(showLogs){
            System.out.println("FILL DATABASE");
        }

        if (showLogs){
            System.out.println("Save vehicle...");
        }
        vehicleController.save();

        if(showLogs){
            System.out.println("Save colour...");
        }
        colourController.save();

        if(showLogs){
            System.out.println("Save bodyStyle...");
        }
        bodyStyleController.save();

        if(showLogs){
            System.out.println("Save insuranceType...");
        }
        insuranceTypeController.save();

        if(showLogs){
            System.out.println("Save owner...");
        }
        ownerController.save();

        if(showLogs){
            System.out.println("Save address...");
        }
        addressController.save();

        if(showLogs){
            System.out.println("Save ownedVehicle...");
        }
        ownedVehicleController.save(100);

        if(showLogs){
            System.out.println("Save insurance...");
        }
        insuranceController.save(100);

    }

    public void insurances() {
        InsurancesInvoker insurancesInvoker = new InsurancesInvoker();
        insurancesInvoker.insuranceTest(100);
        insurancesInvoker.insuranceTest(1000);
        insurancesInvoker.insuranceTest(10000);
    }


    public void ownedVehicles(){
        System.out.println("--------------");
        OwnedVehicleInvoker ownedVehicleInvoker = new OwnedVehicleInvoker();
        ownedVehicleInvoker.saveOwnedVehicles100();
        ownedVehicleInvoker.saveOwnedVehicles1000();
        ownedVehicleInvoker.saveOwnedVehicles10000();

    }


}
