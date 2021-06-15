package com.example.service;

import com.example.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto productById(int id);
    void addProduct(ProductDto productDto);
    void deleteProductById(int id);
}
