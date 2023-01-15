package com.example.orderservice.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String userId;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String role;

}
