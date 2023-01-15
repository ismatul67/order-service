package com.example.orderservice.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private String productId;
    private String name;

}
