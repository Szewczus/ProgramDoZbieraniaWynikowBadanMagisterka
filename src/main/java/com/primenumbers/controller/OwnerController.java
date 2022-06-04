package com.primenumbers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.dto.OwnerDto;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OwnerController {
    private List<OwnerDto> generateOwners() {
        List<OwnerDto> dtos = new ArrayList<>();
        dtos.add(OwnerDto.builder().id(1L).name("Feliks").surname("Olszewski").birthdate(Date.valueOf("1948-02-16")).pesel(48021667475L).build());
        dtos.add(OwnerDto.builder().id(2L).name("Benedykt").surname("Sawicki").birthdate(Date.valueOf("1993-05-25")).pesel(93052577435L).build());
        dtos.add(OwnerDto.builder().id(3L).name("Katarzyna").surname("Nowakowska").birthdate(Date.valueOf("1956-10-12")).pesel(56101285583L).build());
        dtos.add(OwnerDto.builder().id(4L).name("Natasza").surname("Borkowska").birthdate(Date.valueOf("1991-10-09")).pesel(91100976988L).build());
        dtos.add(OwnerDto.builder().id(5L).name("Gertruda").surname("Czarnecka").birthdate(Date.valueOf("1939-05-30")).pesel(39053022963L).build());
        dtos.add(OwnerDto.builder().id(6L).name("Bolesława").surname("Maciejewska").birthdate(Date.valueOf("1984-02-05")).pesel(84020530389L).build());
        dtos.add(OwnerDto.builder().id(7L).name("Seweryn").surname("Dąbrowski").birthdate(Date.valueOf("1989-11-12")).pesel(89111243915L).build());
        dtos.add(OwnerDto.builder().id(8L).name("Zoja").surname("Szczepańska").birthdate(Date.valueOf("1997-08-07")).pesel(97080777609L).build());
        dtos.add(OwnerDto.builder().id(9L).name("Anastazja").surname("Grabowska").birthdate(Date.valueOf("1944-02-12")).pesel(44021207228L).build());
        dtos.add(OwnerDto.builder().id(10L).name("Patrycja").surname("Michalska").birthdate(Date.valueOf("1987-12-21")).pesel(87122160726L).build());

        return dtos;
    }

    void saveOwners() throws Exception {
        String json = new ObjectMapper().writeValueAsString(generateOwners());

        long start = System.nanoTime();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.saveOwners(generateOwners());
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("Elapsed Time in nano seconds: " + (end - start));
    }
    
    
}
