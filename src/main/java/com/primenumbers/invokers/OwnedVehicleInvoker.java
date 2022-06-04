package com.primenumbers.invokers;

import com.primenumbers.controller.OwnedVehicleController;

import java.util.ArrayList;
import java.util.List;

public class OwnedVehicleInvoker {
    public static void main(String[] args) {

    }

    public void saveOwnedVehicles100() {
        ownedVehicleTest(100);
    }

    public void saveOwnedVehicles1000() {
        ownedVehicleTest(1000);
    }

    public void saveOwnedVehicles10000() {
        ownedVehicleTest(10000);
    }


    private void ownedVehicleTest(int amount){
        OwnedVehicleController ownedVehicleController = new OwnedVehicleController();
        ownedVehicleController.delete(); //by najpierw wyczyscic tabelę

        System.out.println("Save OwnedVehicle " + amount +" Times: ");
        List<Long> savingTimes = new ArrayList<>();
        List<Long> updateTimes = new ArrayList<>();
        List<Long> deletingTimes = new ArrayList<>();

        for(int i = 0; i<50; i++) {

            long saveStart = System.currentTimeMillis();
            ownedVehicleController.save(amount);
            long saveEnd = System.currentTimeMillis();
            savingTimes.add(saveEnd-saveStart);

            long updateStart = System.currentTimeMillis();
            ownedVehicleController.update(amount);
            long updateEnd = System.currentTimeMillis();
            updateTimes.add(updateEnd-updateStart);

            long deleteStart = System.currentTimeMillis();
            ownedVehicleController.delete();
            long deleteEnd = System.currentTimeMillis();
            deletingTimes.add(deleteEnd-deleteStart);

            System.out.println((i+1) + ": save: " + (saveEnd-saveStart) + ", update: " + (updateEnd-updateStart) + ", delete: " + (deleteEnd-deleteStart));
        }

        System.out.println("Save OwnedVehicle " + amount +" Times: ");
        System.out.println("SaveTimes: ");
        for(long time : savingTimes) {
            System.out.println(time);
        }
        System.out.println("UpdateTimess: ");
        for(long time : updateTimes) {
            System.out.println(time);
        }
        System.out.println("DeleteTimes: ");
        for(long time : deletingTimes) {
            System.out.println(time);
        }

    }
}
