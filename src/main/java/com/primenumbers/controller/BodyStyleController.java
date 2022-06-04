package com.primenumbers.controller;

import com.primenumbers.connection.ConnectionHelper;
import com.primenumbers.dto.BodyStyleDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BodyStyleController {
    private List<BodyStyleDto> generate(){
        List<BodyStyleDto> bodyStyleDtos = new ArrayList<>();
        bodyStyleDtos.add(BodyStyleDto.builder().id(1L).style("Buggy").doorNumber(2).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(2L).style("Cabriolet").doorNumber(2).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(3L).style("Pickup").doorNumber(5).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(4L).style("Panel van").doorNumber(5).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(5L).style("Estate car").doorNumber(5).build());

        bodyStyleDtos.add(BodyStyleDto.builder().id(6L).style("Hearse").doorNumber(5).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(7L).style("Flower car").doorNumber(2).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(8L).style("Microvan").doorNumber(5).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(9L).style("Minivan").doorNumber(5).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(10L).style("Panel van").doorNumber(2).build());
        bodyStyleDtos.add(BodyStyleDto.builder().id(11L).style("Supercar").doorNumber(2).build());

        return bodyStyleDtos;
    }

    public void save() throws Exception {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            connectionHelper.saveBodyStyles(generate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
