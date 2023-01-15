package com.example.orderservice.model.request;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String role;

}
