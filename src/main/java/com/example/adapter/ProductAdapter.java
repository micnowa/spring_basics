package com.example.adapter;

import com.example.dto.ProductDto;

import java.util.List;

public interface ProductAdapter {
    List<ProductDto> getAllProducts();

    ProductDto getProductById(int id);

    void addProduct(ProductDto productDto);

    void deleteProductById(int id);
}
