package com.primenumbers.controller;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.dto.ColourDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ColourController {
    private List<ColourDto> generate() {
        List<ColourDto> lista = new ArrayList<>();
        lista.add(ColourDto.builder().id(1L).carColour("żółty").build());
        lista.add(ColourDto.builder().id(2L).carColour("niebieski").build());
        lista.add(ColourDto.builder().id(3L).carColour("zielony").build());
        lista.add(ColourDto.builder().id(4L).carColour("fioletowy").build());
        lista.add(ColourDto.builder().id(5L).carColour("biały").build());
        lista.add(ColourDto.builder().id(6L).carColour("czarny").build());
        lista.add(ColourDto.builder().id(7L).carColour("czerwony").build());
        lista.add(ColourDto.builder().id(8L).carColour("różowy").build());
        lista.add(ColourDto.builder().id(9L).carColour("srebry").build());
        lista.add(ColourDto.builder().id(10L).carColour("złoty").build());
        lista.add(ColourDto.builder().id(11L).carColour("kameleon").build());
        return lista;
    }

    public void save(){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.saveColours(generate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
