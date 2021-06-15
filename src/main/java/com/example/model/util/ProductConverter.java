package com.example.model.util;

import com.example.dto.ProductDto;
import com.example.model.Product;

import java.math.BigDecimal;

public class ProductConverter {

    private ProductConverter() {
        throw new IllegalStateException("Utility class");
    }

    public static Product convertToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(new BigDecimal(productDto.getPrice()));
        return product;
    }
}
