package com.example.service;

import com.example.adapter.ProductAdapter;
import com.example.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    private final ProductAdapter productAdapter;

    @Autowired
    public ProductServiceImpl(ProductAdapter productAdapter) {
        this.productAdapter = productAdapter;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productAdapter.getAllProducts();
    }

    @Override
    public ProductDto productById(int id) {
        return productAdapter.getProductById(id);
    }

    @Override
    public void addProduct(ProductDto productDto) {
        productAdapter.addProduct(productDto);
    }

    @Override
    public void deleteProductById(int id) {
        productAdapter.deleteProductById(id);
    }
}
