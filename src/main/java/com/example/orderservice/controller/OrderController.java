package com.example.orderservice.controller;

import com.example.orderservice.model.request.OrderRequest;
import com.example.orderservice.model.response.RestResponse;
import com.example.orderservice.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Order APIs")
@Slf4j
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderServiceImpl;

    @ApiOperation(value = "Create Order", notes = "API to Create Order")
    @PostMapping(value = "/v1/create")
    public ResponseEntity<RestResponse> pebRequest(@RequestBody OrderRequest request) {
        RestResponse response = new RestResponse(null, orderServiceImpl.createOrder(request));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Find My Order", notes = "API to Find My Order")
    @GetMapping(value = "/v1/find/{useridOrUsername}")
    public ResponseEntity<RestResponse> findMyOrder (@PathVariable String useridOrUsername) {
        RestResponse response = new RestResponse(orderServiceImpl.seeMyOrder(useridOrUsername), "Here your data");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Order", notes = "API to Delete Order")
    @DeleteMapping(value = "/v1/delete/{id}")
    public ResponseEntity<RestResponse> deleteOrder (@PathVariable String id) {
        RestResponse response = new RestResponse(null, orderServiceImpl.deleteOrder(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
