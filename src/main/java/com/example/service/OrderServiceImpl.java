package com.example.service;

import com.example.adapter.OrderAdapter;
import com.example.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderAdapter orderAdapter;

    @Autowired
    public OrderServiceImpl(OrderAdapter orderAdapter) {
        this.orderAdapter = orderAdapter;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderAdapter.getAllOrders();
    }

    @Override
    public OrderDto getOrderById(long id) {
        return orderAdapter.getOrderById(id);
    }

    @Override
    public boolean addOrder(OrderDto orderDto) {
        return false;
    }

    @Override
    public boolean deleteOrderById(int id) {
        return false;
    }
}
