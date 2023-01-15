package com.example.orderservice.service;

import com.example.orderservice.model.request.UserRequest;
import com.example.orderservice.model.response.UserResponse;

import java.util.List;

public interface UserService {

    String createUser(UserRequest request);
    List<UserResponse> seeUsers();
    String deleteUser(String userId);

}
