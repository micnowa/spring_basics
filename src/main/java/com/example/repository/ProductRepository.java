package com.example.repository;

import com.example.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
    Product findProductByProductId(int id);
    Product save(Product product);
    void deleteByProductId(int id);
}
