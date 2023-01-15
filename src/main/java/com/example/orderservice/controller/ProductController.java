package com.example.orderservice.controller;

import com.example.orderservice.model.request.ProductRequest;
import com.example.orderservice.model.response.RestResponse;
import com.example.orderservice.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Product APIs")
@Slf4j
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productServiceImpl;

    @ApiOperation(value = "Create Product", notes = "API to Create Product")
    @PostMapping(value = "/v1/create")
    public ResponseEntity<RestResponse> createProduct (@RequestBody ProductRequest request) {
        RestResponse response = new RestResponse(null, productServiceImpl.createProduct(request));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Find Products", notes = "API to Find Products")
    @GetMapping(value = "/v1/find-all")
    public ResponseEntity<RestResponse> findProducts () {
        RestResponse response = new RestResponse(productServiceImpl.seeProducts(), "Here your data");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Product", notes = "API to Delete Product")
    @DeleteMapping(value = "/v1/delete/{id}")
    public ResponseEntity<RestResponse> deleteProduct (@PathVariable String id) {
        RestResponse response = new RestResponse(null, productServiceImpl.deleteProduct(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
