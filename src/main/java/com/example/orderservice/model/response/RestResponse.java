package com.example.orderservice.model.response;


import lombok.Data;

@Data
public class RestResponse {

    private Object data;

    private String message;

    public RestResponse(Object data, String message) {
        this.data = data;
        this.message = message;
    }

    public RestResponse() {
    }
}
