package com.example.controller;

import com.example.dto.ProductDto;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<ProductDto> getAllUsers() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getUserById(@PathVariable int id) {
        return productService.productById(id);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
    }

    @PostMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        productService.deleteProductById(id);
    }
}
