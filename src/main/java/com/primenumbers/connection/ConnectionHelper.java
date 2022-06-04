package com.primenumbers.connection;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.primenumbers.dto.InsuranceDto;
import com.primenumbers.entity.Insurance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ConnectionHelper {
    private final ObjectMapper objectMapper;
    private final ConnectionBean connectionBean;
    private final String TAG = "ConnectionHelper";
    public ConnectionHelper(){
        objectMapper = new ObjectMapper();
        connectionBean = new ConnectionBean("http://127.0.0.1:8080/study");
    }


    public void saveInsurances(List<InsuranceDto> insurances, String title) throws IOException {
        connectionBean.postObjects(insurances, "/insurance/saveInsurances", title);
    }


}
