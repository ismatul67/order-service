package com.example.orderservice.service;

import com.example.orderservice.model.entity.Product;
import com.example.orderservice.model.request.ProductRequest;
import com.example.orderservice.model.response.ProductResponse;
import com.example.orderservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String createProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        productRepository.save(product);
        return "Success Create Product";
    }

    @Override
    public List<ProductResponse> seeProducts() {
        List<ProductResponse> result = new ArrayList<>();
        productRepository.findAll().forEach(data ->{
            ProductResponse productResponse = ProductResponse.builder()
                    .productId(data.getId())
                    .name(data.getName())
                    .build();
            result.add(productResponse);
        });
        return result;
    }

    @Override
    public String deleteProduct(String productId) {
        productRepository.deleteById(productId);
        return "Product Was Deleted";
    }
}
