package com.example.Springonlinestorenew.service;

import com.example.Springonlinestorenew.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductServiceImplIntTest {
    @Autowired
    private ProductRepository repository;

    @Test
    void initialisedProductService(){
        ProductServiceImpl service = new ProductServiceImpl(repository);
        assertNotNull(service);
    }
}
