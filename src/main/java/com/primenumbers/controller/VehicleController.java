package com.primenumbers.controller;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.dto.VehicleDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleController {

    public void save(){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.saveVehicles(generate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<VehicleDto> generate(){
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        vehicleDtos.add(VehicleDto.builder().id(1L).brand("Volkswagen").model("Golf").build());
        vehicleDtos.add(VehicleDto.builder().id(2L).brand("Volkswagen").model("Golf Plus").build());
        vehicleDtos.add(VehicleDto.builder().id(3L).brand("Volkswagen").model("Passat").build());
        vehicleDtos.add(VehicleDto.builder().id(4L).brand("Volkswagen").model("Polo").build());
        vehicleDtos.add(VehicleDto.builder().id(5L).brand("Volkswagen").model("Taigo").build());
        vehicleDtos.add(VehicleDto.builder().id(6L).brand("Volkswagen").model("Tiguan").build());
        vehicleDtos.add(VehicleDto.builder().id(7L).brand("Volkswagen").model("Touran").build());
        vehicleDtos.add(VehicleDto.builder().id(8L).brand("Volkswagen").model("Sharan").build());
        vehicleDtos.add(VehicleDto.builder().id(9L).brand("Volkswagen").model("ID.4").build());
        vehicleDtos.add(VehicleDto.builder().id(10L).brand("Volkswagen").model("ID.3").build());
        return vehicleDtos;
    }
}
