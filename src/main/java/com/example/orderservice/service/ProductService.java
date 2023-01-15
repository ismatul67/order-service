package com.example.orderservice.service;

import com.example.orderservice.model.request.ProductRequest;
import com.example.orderservice.model.response.ProductResponse;

import java.util.List;

public interface ProductService {

    String createProduct(ProductRequest request);
    List<ProductResponse> seeProducts();
    String deleteProduct(String productId);

}
