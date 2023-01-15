package com.example.orderservice.service;

import com.example.orderservice.model.request.OrderRequest;
import com.example.orderservice.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
    String createOrder(OrderRequest request);
    List<OrderResponse> seeMyOrder(String userIdOrUserName);
    String deleteOrder(String orderId);
}
