package com.hsaugsburg.HRManagementTool.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonMapper {

    public static  String parseObjectToJson(Object javaObject) throws JsonProcessingException {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            return ow.writeValueAsString(javaObject);
        }catch (Exception exception){
            System.out.print(exception.getMessage());
            throw exception;
        }

    }

    public static Object parseJsonToObject(String json,Object objectToParse) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, objectToParse.getClass());
        }catch (Exception exception){
            System.out.print("parsing Problem");
            throw exception;
        }
    }
}
