package com.example.adapter;

import com.example.dto.ProductDto;
import com.example.exception.product.ProductNotFoundException;
import com.example.model.util.ProductConverter;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductAdapterImpl implements ProductAdapter {
    ProductRepository productRepository;

    @Autowired
    public ProductAdapterImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(int id) {
        var product = productRepository.findProductByProductId(id);
        if(null == product) {
            throw new ProductNotFoundException(String.format("Product with id %d does not exist!", id));
        }
        return new ProductDto(product);
    }

    @Override
    public void addProduct(ProductDto productDto) {
        productRepository.save(ProductConverter.convertToProduct(productDto));
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteByProductId(id);
    }
}
