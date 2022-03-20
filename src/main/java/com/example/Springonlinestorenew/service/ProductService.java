package com.example.Springonlinestorenew.service;

import com.example.Springonlinestorenew.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
    List<Product> getAllByCategory(String category);
    List<Product> getAllByCode(String productCode);

}
