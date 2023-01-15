package com.example.orderservice.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "order")
public class Order {

    @Id
    private String id;
    private String userId;
    private String productId;
    private Long amount;
    private String status;
}
