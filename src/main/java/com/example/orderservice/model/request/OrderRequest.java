package com.example.orderservice.model.request;

import lombok.Data;

@Data
public class OrderRequest {

    private String orderId;
    private String userId;
    private String productId;
    private Long amount;
    private String status;
}
