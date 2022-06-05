package com.primenumbers.invokers;

import com.primenumbers.controller.InsuranceController;

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
        System.out.println("SAVING INSURANCE "+ amount +" RECORDS: ");
        for (long timeSave: savingTimes){
            System.out.println(timeSave);
        }

        System.out.println("GET INSURANCE "+ amount +" RECORDS: ");
        for (long timeget: getTimes){
            System.out.println(timeget);
        }

        System.out.println("UPDATE INSURANCE "+ amount +" RECORDS: ");
        for (long timeSave: savingTimes){
            System.out.println(timeSave);
        }

        System.out.println("DELETE INSURANCE "+ amount +" RECORDS: ");
        for (long timeSave: savingTimes){
            System.out.println(timeSave);
        }
    }
}
