package com.example.orderservice.controller;

import com.example.orderservice.model.request.UserRequest;
import com.example.orderservice.model.response.RestResponse;
import com.example.orderservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User APIs")
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @ApiOperation(value = "Create User", notes = "API to Create User")
    @PostMapping(value = "/v1/create")
    public ResponseEntity<RestResponse> createUser ( @RequestBody UserRequest request) {
        RestResponse response = new RestResponse(null, userServiceImpl.createUser(request));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Find Users", notes = "API to Find Users")
    @GetMapping(value = "/v1/find-all")
    public ResponseEntity<RestResponse> findUsers () {
        RestResponse response = new RestResponse(userServiceImpl.seeUsers(), "Here your data");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete User", notes = "API to Delete User")
    @DeleteMapping(value = "/v1/delete/{id}")
    public ResponseEntity<RestResponse> deleteUser(@PathVariable String id) {
        RestResponse response = new RestResponse(null, userServiceImpl.deleteUser(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
