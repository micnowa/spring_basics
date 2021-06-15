package com.example.dto;

import com.example.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private String name;
    private String price;

    public ProductDto(Product product) {
        this.name = product.getName();
        this.price = product.getPrice().toPlainString();
    }
}
