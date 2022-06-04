package com.primenumbers.controller;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.dto.AddressDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressController {
    private List<AddressDto> generate() {
        List<AddressDto> dtos = new ArrayList<>();
        dtos.add(AddressDto.builder().id(1L).postalCode("00-001").city("Warszawa").street("al. Aleja 3 Maja").houseNumber(5).fkOwnerId(1L).build());
        dtos.add(AddressDto.builder().id(2L).postalCode("08-500").city("Ryki").street("ul. 15 Pułku Piechoty Wilków AK").houseNumber(15).fkOwnerId(2L).build());
        dtos.add(AddressDto.builder().id(3L).postalCode("10-001").city("Olsztyn").street("al. Tadeusza Kościuszki").houseNumber(7).apartmentNumber(15).fkOwnerId(3L).build());
        dtos.add(AddressDto.builder().id(4L).postalCode("22-500").city("Hrubieszów").street("ul. 3 Maja").houseNumber(3).fkOwnerId(4L).build());
        dtos.add(AddressDto.builder().id(5L).postalCode("91-520").city("Łódź").street("ul. Renesansowa").houseNumber(58).fkOwnerId(5L).build());
        dtos.add(AddressDto.builder().id(6L).postalCode("75-616").city("Koszalin").street("ul. Zwycięstwa").houseNumber(82).fkOwnerId(6L).build());
        dtos.add(AddressDto.builder().id(7L).postalCode("44-335").city("Jastrzębie-zdrój").street("ul. Bukowa").houseNumber(76).fkOwnerId(7L).build());
        dtos.add(AddressDto.builder().id(8L).postalCode("52-114").city("Wrocław").street("ul. Laotańska").houseNumber(102).fkOwnerId(8L).build());
        dtos.add(AddressDto.builder().id(9L).postalCode("41-253").city("Czeladź").street("ul. Spacerowa").houseNumber(42).fkOwnerId(9L).build());
        dtos.add(AddressDto.builder().id(10L).postalCode("87-122").city("Grębocin").street("ul. Dworcowa").houseNumber(40).fkOwnerId(10L).build());
        dtos.add(AddressDto.builder().id(11L).postalCode("60-406").city("Poznań").street("ul. Nidziańska").houseNumber(117).fkOwnerId(1L).build());
        dtos.add(AddressDto.builder().id(12L).postalCode("42-460").city("Mierzęcice").street("ul. Wolności").houseNumber(25).fkOwnerId(2L).build());
        dtos.add(AddressDto.builder().id(13L).postalCode("35-231").city("Rzeszów").street("ul. Dobra").houseNumber(34).fkOwnerId(3L).build());
        return dtos;
    }

    void save() throws Exception {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.saveAddresses(generate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
