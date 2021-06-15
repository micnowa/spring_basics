package com.example.repository;

import com.example.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findOrderByOrderId(long id);
    List<Order> findAll();
}
