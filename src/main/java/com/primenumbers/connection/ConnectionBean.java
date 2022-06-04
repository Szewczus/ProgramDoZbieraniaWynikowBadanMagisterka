package com.primenumbers.connection;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionBean {
    private final ObjectMapper objectMapper;
    private String serverAddress;
    private String authHeader;

    public ConnectionBean(String serverAddress){
        this.objectMapper = new ObjectMapper();
        this.serverAddress = serverAddress;
    }

    /**
     *
     * @param object - single object that will be parsed to json to be send to backend
     * @param postfix - address postfix
     * @return returns json that has to mapped to an object or object array
     * @throws IOException - can throw exceptions
     */
    public String postObject(Object object, String postfix, String title) throws IOException {
        String input = objectMapper.writeValueAsString(object);
        return postData(input, postfix, title);
    }

    /**
     *
     * @param objectList - list of objects that will be parsed to json to be send to backend
     * @param postfix - address postfix
     * @return  returns json that has to mapped to an object or object array
     * @throws IOException - can throw exceptions
     */
    public <T> String postObjects(List<T> objectList, String postfix, String title) throws IOException {
        String input = objectMapper.writeValueAsString(objectList);
        return postData(input, postfix, title);
    }



    private String postData(String input, String postfix, String title) throws IOException {
        HttpURLConnection connection = openConnection(postfix);
        long start = System.currentTimeMillis();
        sendData(connection, input);    //if input is either null of empty no data will be send to the backend
        long end = System.currentTimeMillis();
        long result = end-start;
        System.out.println(title+": "+result);
        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + connection.getResponseCode());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (connection.getInputStream())));
        return readData(br);
    }

    private HttpURLConnection openConnection(String postfix) throws IOException {
        URL address = new URL(serverAddress + postfix);
        HttpURLConnection conn = (HttpURLConnection) address.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");          //somehow android runtime sends all requests as POSTs even when request method is set to GET
        conn.setRequestProperty("Content-Type", "application/json");
        if(authHeader != null && !authHeader.isEmpty()){
            conn.setRequestProperty("Authorization", authHeader);
        }
        return conn;
    }

    private HttpURLConnection openConnection(String postfix, byte[] postData) throws IOException {
        URL address = new URL(serverAddress + postfix);
        HttpURLConnection conn = (HttpURLConnection) address.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");          //somehow android runtime sends all requests as POSTs even when request method is set to GET
        int postDataLength = postData.length;

        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setUseCaches(false);
        if(authHeader != null && !authHeader.isEmpty()){
            conn.setRequestProperty("Authorization", authHeader);
        }
        return conn;
    }

    private String readData(BufferedReader br) throws IOException {
        String output;
        StringBuilder stringBuilder = new StringBuilder();
        while ((output = br.readLine()) != null) {
            stringBuilder.append(output);
        }
        return stringBuilder.toString();
    }

    private void sendData(HttpURLConnection connection, String input) throws IOException {
        if (input == null || input.isEmpty()){
            return;
        }
        OutputStream os = connection.getOutputStream();
        os.write(input.getBytes());
        os.flush();
    }
}
