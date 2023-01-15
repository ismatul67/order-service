package com.example.orderservice.service;

import com.example.orderservice.model.entity.User;
import com.example.orderservice.model.request.UserRequest;
import com.example.orderservice.model.response.UserResponse;
import com.example.orderservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(UserRequest request) {
        User user = new User();
        user.setRole(request.getRole());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        userRepository.save(user);
        return "Success Create User";
    }

    @Override
    public List<UserResponse> seeUsers() {
        List<UserResponse> result = new ArrayList<>();
        userRepository.findAll().forEach(data ->{
            UserResponse userResponse = UserResponse.builder()
                    .userId(data.getId())
                    .email(data.getEmail())
                    .role(data.getRole())
                    .firstname(data.getFirstname())
                    .lastname(data.getLastname())
                    .username(data.getUsername())
                    .build();
            result.add(userResponse);
        });
        return result;
    }

    @Override
    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return "User Was Deleted";
    }
}
