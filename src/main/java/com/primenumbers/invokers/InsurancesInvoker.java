package com.primenumbers.invokers;

import com.primenumbers.controller.InsuranceController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InsurancesInvoker {
    public void insuranceTest(int amount){
        InsuranceController insuranceController = new InsuranceController();
        insuranceController.deleteAll();

        List<Long> savingTimes = new ArrayList<>();
        List<Long> getTimes = new ArrayList<>();
        List<Long> updateTimes = new ArrayList<>();
        List<Long> deletingTimes = new ArrayList<>();

        LocalDate date = LocalDate.parse("2010-01-01");
        for(int i=0; i<50; i++){

            long saveStart = System.currentTimeMillis();
            insuranceController.save(amount);
            long saveEnd = System.currentTimeMillis();
            long resultSave = saveEnd-saveStart;
            savingTimes.add(resultSave);


            long  updateStart = System.currentTimeMillis();
            insuranceController.update(amount, date);
            long updateEnd = System.currentTimeMillis();
            long resultUpdate = updateEnd-updateStart;
            updateTimes.add(resultUpdate);
            date = date.plusDays(10);

            long getStart = System.currentTimeMillis();
            insuranceController.findAll();
            long getEnd = System.currentTimeMillis();
            long resultGet = getEnd-getStart;
            getTimes.add(resultGet);


            long deleteStart = System.currentTimeMillis();
            insuranceController.deleteAll();
            long deleteEnd = System.currentTimeMillis();
            long resultDelete = deleteEnd - deleteStart;
            deletingTimes.add(resultDelete);

            System.out.println((i+1) + " Insurance "+ amount+" record - save: " + resultSave +" get: "+ resultGet+", update: " + resultUpdate + ", delete: " + resultDelete);
        }

        String filename = "results_for_" + amount + "_insurance.txt";

        try{
            PrintWriter writer = new PrintWriter(filename, "UTF-8");

            System.out.println("SAVING INSURANCE "+ amount +" RECORDS: ");
            writer.println("SAVING INSURANCE "+ amount +" RECORDS:");
            for (long timeSave: savingTimes){
                writer.println(timeSave);
                System.out.println(timeSave);
            }

            System.out.println("GET INSURANCE "+ amount +" RECORDS: ");
            writer.println("GET INSURANCE "+ amount +" RECORDS:");
            for (long timeget: getTimes){
                writer.println(timeget);
                System.out.println(timeget);
            }

            System.out.println("UPDATE INSURANCE "+ amount +" RECORDS: ");
            writer.println("UPDATE INSURANCE "+ amount +" RECORDS: ");
            for (long timeSave: updateTimes){
                writer.println(timeSave);
                System.out.println(timeSave);
            }

            System.out.println("DELETE INSURANCE "+ amount +" RECORDS: ");
            writer.println("DELETE INSURANCE "+ amount +" RECORDS: ");
            for (long timeSave: deletingTimes){
                writer.println(timeSave);
                System.out.println(timeSave);
            }
            writer.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
