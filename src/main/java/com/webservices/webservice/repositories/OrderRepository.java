package com.webservices.webservice.repositories;

import com.webservices.webservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Order, Long>{
}
