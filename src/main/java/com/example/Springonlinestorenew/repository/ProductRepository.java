package com.example.Springonlinestorenew.repository;

import com.example.Springonlinestorenew.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByCode(String code);

}
