package com.example.dto;

import com.example.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {
    private final String userName;
    private final String userSurname;
//    private final List<String> productNames = new ArrayList<>();

    public OrderDto(Order order) {
        this.userName = order.getPerson().getName();
        this.userSurname = order.getPerson().getSurname();
//        order.getProducts().forEach(product -> productNames.add(product.getName()));
    }
}
