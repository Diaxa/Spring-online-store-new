package com.example.Springonlinestorenew.thymeleaf.service;

import com.example.Springonlinestorenew.entity.Product;
import com.example.Springonlinestorenew.repository.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> maybeProduct = productRepository.findById(id);

        if (maybeProduct.isEmpty()) {
            throw new RuntimeException("Product with id " + id + " was not found.");
        }

        return maybeProduct.get();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public  List<Product> getAllByCategory(String category){
        return productRepository.findByCategory(category);
    }
    public  List<Product> getAllByCode(String productCode){
        return productRepository.findByCode(productCode);
    }








}
