package com.primenumbers.invokers;

import com.primenumbers.Main;
import com.primenumbers.controller.OwnedVehicleController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OwnedVehicleInvoker {
    public static void main(String[] args) {

    }

    public void saveOwnedVehicles100() {
        try {
            ownedVehicleTest(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveOwnedVehicles1000() {
        try {
            ownedVehicleTest(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveOwnedVehicles10000() {
        try {
            ownedVehicleTest(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void ownedVehicleTest(int amount) throws InterruptedException {
        OwnedVehicleController ownedVehicleController = new OwnedVehicleController();
        ownedVehicleController.delete(); //by najpierw wyczyscic tabelę

        System.out.println("Save OwnedVehicle " + amount +" Records: ");
        List<Long> savingTimes = new ArrayList<>();
        List<Long> getTimes = new ArrayList<>();
        List<Long> selectWithJoinTimes = new ArrayList<>();
        List<Long> updateTimes = new ArrayList<>();
        List<Long> deletingTimes = new ArrayList<>();

        for(int i = 0; i<50; i++) {

            Main main = new Main();
            main.fillDatabase(false);

            Thread.sleep(1000);

            long selectWithJoinStart = System.currentTimeMillis();
            ownedVehicleController.selectWithJoin();
            long selectWithJoinEnd = System.currentTimeMillis();
            selectWithJoinTimes.add(selectWithJoinEnd-selectWithJoinStart);

            Thread.sleep(1000);

            long updateStart = System.currentTimeMillis();
            ownedVehicleController.update(amount);
            long updateEnd = System.currentTimeMillis();
            updateTimes.add(updateEnd-updateStart);

            Thread.sleep(1000);

            long getStart = System.currentTimeMillis();
            ownedVehicleController.findAll();
            long getEnd = System.currentTimeMillis();
            getTimes.add(getEnd-getStart);

            Thread.sleep(1000);

            long deleteStart = System.currentTimeMillis();
            ownedVehicleController.delete();
            long deleteEnd = System.currentTimeMillis();
            deletingTimes.add(deleteEnd-deleteStart);

            Thread.sleep(1000);

            long saveStart = System.currentTimeMillis();
            ownedVehicleController.save(amount);
            long saveEnd = System.currentTimeMillis();
            savingTimes.add(saveEnd-saveStart);

            Thread.sleep(1000);

            main.clearDatabase(false);

            Thread.sleep(1000);

            System.out.println((i+1) + ": save: " + (saveEnd-saveStart) +", get: " +(getEnd-getStart)+", selectWithJoin: " +(selectWithJoinEnd-selectWithJoinStart)+", update: " + (updateEnd-updateStart) + ", delete: " + (deleteEnd-deleteStart));
        }

        //write to file
        String filename = "results_for_" + amount + "_owned_vehicles.txt";



        try{
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            System.out.println("OwnedVehicle " + amount +" Records: ");
            writer.println("OwnedVehicle " + amount +" Records: " );
            System.out.println("SaveTimes: ");
            writer.println("SaveTimes: ");
            for(long time : savingTimes) {
                System.out.println(time);
                writer.println(time);
            }

            System.out.println("GetTimes: ");
            writer.println("GetTimes: ");
            for(long time : getTimes) {
                System.out.println(time);
                writer.println(time);
            }

            System.out.println("Select with join: ");
            writer.println("SelectWithJoinTimes: ");
            for(long time : selectWithJoinTimes) {
                System.out.println(time);
                writer.println(time);
            }

            System.out.println("UpdateTimess: ");
            writer.println("UpdateTimes: ");
            for(long time : updateTimes) {
                System.out.println(time);
                writer.println(time);
            }
            System.out.println("DeleteTimes: ");
            writer.println("DeleteTimes");
            for(long time : deletingTimes) {
                System.out.println(time);
                writer.println(time);
            }
            writer.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
