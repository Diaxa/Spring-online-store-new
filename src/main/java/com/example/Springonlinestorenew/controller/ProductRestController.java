package com.example.Springonlinestorenew.controller;

import com.example.Springonlinestorenew.entity.Product;
import com.example.Springonlinestorenew.thymeleaf.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/product")
    public List<Product> getProduct() {
        List<Product> productList =  productService.getAllProducts();
        log.info("Goods category size " + productList.size() );
       return productList;
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PostMapping("/goods")
    public Product getProduct(@RequestBody Product product){
        return  productService.saveProduct(product);
    }

    @DeleteMapping("/goods/{id}")
    public void getProducts(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/find/{category}")
    public List<Product> getProducts(@PathVariable String category) {
        List<Product> productCategory =  productService.getAllByCategory(category);
        log.info("Goods category size " + productCategory.size() );
        return productCategory;
    }

}
