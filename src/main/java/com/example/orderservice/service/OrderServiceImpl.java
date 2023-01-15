package com.example.orderservice.service;

import com.example.orderservice.model.entity.Order;
import com.example.orderservice.model.entity.Product;
import com.example.orderservice.model.entity.User;
import com.example.orderservice.model.request.OrderRequest;
import com.example.orderservice.model.response.OrderResponse;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.repository.ProductRepository;
import com.example.orderservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements  OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public String createOrder(OrderRequest request) {
        Order order;
        if (request.getOrderId()!=null){
            order = orderRepository.findById(request.getOrderId()).get();
        }else{
            order = new Order();
        }
        if(request.getProductId()!=null){
            order.setProductId(request.getProductId());
        }
        if (request.getUserId()!=null){
            order.setUserId(request.getUserId());
        }
        if (request.getAmount()!=null){
            order.setAmount(request.getAmount());
        }

        if (request.getStatus()!=null){
            order.setStatus(request.getStatus());
        }
        orderRepository.save(order);
        return "Success Save Order";
    }

    @Override
    public List<OrderResponse> seeMyOrder(String userIdOrUserName) {
        List<OrderResponse> result = new ArrayList<>();
        User user = userRepository.findById(userIdOrUserName).orElse(userRepository.findUserByUsername(userIdOrUserName));
        if(user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
        orderRepository.findAllByUserId(user.getId()).forEach(data ->{
            Product product = productRepository.findById(data.getProductId()).get();
            OrderResponse orderResponse = OrderResponse.builder()
                    .orderId(data.getId())
                    .username(user.getUsername())
                    .productName(product.getName())
                    .amount(data.getAmount())
                    .status(data.getStatus())
                    .build();
            result.add(orderResponse);
        });
        return result;
    }

    @Override
    public String deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
        return "Order Was Deleted";
    }
}
