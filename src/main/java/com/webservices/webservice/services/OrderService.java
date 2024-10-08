package com.webservices.webservice.services;

import com.webservices.webservice.entities.Order;
import com.webservices.webservice.repositories.OrderRepository;
import com.webservices.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order findOrderById(Long id){
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }
}
