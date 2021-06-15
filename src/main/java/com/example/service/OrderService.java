package com.example.service;

import com.example.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();
    OrderDto getOrderById(long id);
    boolean addOrder(OrderDto orderDto);
    boolean deleteOrderById(int id);

}
