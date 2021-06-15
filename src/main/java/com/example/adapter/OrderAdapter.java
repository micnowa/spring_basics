package com.example.adapter;

import com.example.dto.OrderDto;

import java.util.List;

public interface OrderAdapter {
    List<OrderDto> getAllOrders();
    OrderDto getOrderById(long id);
    boolean addOrder(OrderDto orderDto);
}
