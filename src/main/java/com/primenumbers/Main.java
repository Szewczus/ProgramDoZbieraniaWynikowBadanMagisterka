package com.primenumbers;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.controller.BodyStyleController;
import com.primenumbers.controller.ColourController;
import com.primenumbers.controller.OwnedVehicleController;
import com.primenumbers.controller.VehicleController;
import com.primenumbers.dto.InsuranceDto;
import com.primenumbers.dto.VehicleDto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


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
