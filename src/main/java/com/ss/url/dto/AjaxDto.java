package com.ss.url.dto;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

public class AjaxDto {

    public AjaxDto(){};

    public  AjaxDto(HttpStatus status){
        this.code = status.value();
    }
    public AjaxDto(HttpStatus status,String message){
        this.code = status.value();
        this.message = message;

    }
    private  int code;

    private  String message;

    private HashMap<String,Object> data = new HashMap<>();

    public int getCode() {
        return code;
    }

    public void setCode(HttpStatus status) {
        this.code = status.value();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public void put(String key, Object value){
         data.put(key,value);
    }

    @Override
    public String toString() {
        return "AjaxDto{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
