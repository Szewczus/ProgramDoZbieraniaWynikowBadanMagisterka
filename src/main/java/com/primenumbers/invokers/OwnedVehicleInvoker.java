package com.primenumbers.invokers;

import com.primenumbers.controller.OwnedVehicleController;

import java.util.ArrayList;
import java.util.List;

public class OwnedVehicleInvoker {
    public static void main(String[] args) {

    }


    public void ownedVehicle100(){
        OwnedVehicleController ownedVehicleController = new OwnedVehicleController();
        ownedVehicleController.delete(); //by najpierw wyczyscic tabelę

        System.out.println("Save OwnedVehicle 100 Times: ");
        List<Long> savingTimes = new ArrayList<>();
        List<Long> updateTimes = new ArrayList<>();
        List<Long> deletingTimes = new ArrayList<>();

        for(int i = 0; i<50; i++) {


            ownedVehicleController.save(100);

            ownedVehicleController.update(100);

            ownedVehicleController.delete();
        }

    }
}
