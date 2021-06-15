package com.example.adapter;

import com.example.dto.OrderDto;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderAdapterImpl implements OrderAdapter {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderAdapterImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(OrderDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(long id) {
        return new OrderDto(orderRepository.findOrderByOrderId(id));
    }

    @Override
    public boolean addOrder(OrderDto orderDto) {
        return false;
    }
}
