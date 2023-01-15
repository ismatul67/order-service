package com.example.orderservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "product")
@Builder
public class Product {

    @Id
    private String id;
    private String name;

}
