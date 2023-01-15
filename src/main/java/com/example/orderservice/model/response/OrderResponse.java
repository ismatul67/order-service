package com.example.orderservice.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {

    private String orderId;
    private String username;
    private String productName;
    private Long amount;
    private String status;

}
