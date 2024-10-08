package com.webservices.webservice.controllers;

import com.webservices.webservice.entities.Order;
import com.webservices.webservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> ordersList = orderService.getAllOrders();
        return ResponseEntity.ok().body(ordersList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable Long id){
        Order order = orderService.findOrderById(id);
        return ResponseEntity.ok().body(order);
    }
}
