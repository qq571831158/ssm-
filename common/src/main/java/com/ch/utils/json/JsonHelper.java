package com.ch.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by apple on 2017/5/30.
 */
public class JsonHelper {
    private JsonHelper(){}

    public static String object2str(Object obj){
        String retStr = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retStr = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return retStr;
    }

    public static Object str2object(String str,Class cls){
        Object retObj = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retObj = objectMapper.readValue(str,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retObj;
    }
}
