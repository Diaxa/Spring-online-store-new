package com.example.Springonlinestorenew.service;

import com.example.Springonlinestorenew.entity.Product;
import com.example.Springonlinestorenew.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    private ProductRepository repository;

    @Test
    void whenGetAllProductsReturnsEmptyList() {
    repository = Mockito.mock(ProductRepository.class);
    ProductServiceImpl service = new ProductServiceImpl(repository);

    when(repository.findAll()).thenReturn(new ArrayList<>());

    List<Product> result = service.getAllProducts();
    assertNotNull(result);

    assertEquals(0,result.size());
    }

    @Test
    void whenGetAllProductsReturnsProductList() {
        repository = Mockito.mock(ProductRepository.class);
        ProductServiceImpl service = new ProductServiceImpl(repository);

        List<Product> newProduct = List.of(
                new Product(15l,"Chair","C561"),
                new Product(16l,"Bed","B123"));

        when(repository.findAll()).thenReturn(newProduct);

        List<Product> result = service.getAllProducts();

        assertNotNull(result);
        assertEquals(newProduct,result);
        assertEquals(2,result.size());
    }


    @Test
    void whenProductIdNotFound() {
        repository = Mockito.mock(ProductRepository.class);
        ProductServiceImpl service = new ProductServiceImpl(repository);

        when(repository.findById(any())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.getProductById(15L));

    }
    @Test
    void whenProductIdIsFound() {
        repository = Mockito.mock(ProductRepository.class);
        ProductServiceImpl service = new ProductServiceImpl(repository);

        when(repository.findById(15L)).thenReturn(Optional.of(new Product(15L,"Chair","C156")));
        Product result = service.getProductById(15L);

        assertNotNull(result);
        assertEquals("Chair", result.getCategory());

    }
    @Test
    void whenSaveProduct() {
        repository = Mockito.mock(ProductRepository.class);
        ProductServiceImpl service = new ProductServiceImpl(repository);
        Product productMock = Mockito.mock(Product.class);

        Product result = service.saveProduct(productMock);

       verify(repository,times(1)).save(productMock);

    }

    @Test
    void whenDeleteProduct() {
        repository = Mockito.mock(ProductRepository.class);

        ProductServiceImpl service = new ProductServiceImpl(repository);

        service.deleteProduct(2L);

        verify(repository,times(1)).deleteById(2L);

    }

    @Test
    void getAllByCategoryNow() {
        repository = Mockito.mock(ProductRepository.class);
        ProductServiceImpl service = new ProductServiceImpl(repository);


        when(repository.findByCategory("Chair")).thenReturn(new ArrayList<>());
        List<Product> result = service.getAllByCategory("Chair");

        assertNotNull(result);

        assertEquals(0,result.size());
    }

    @Test
    void getAllByCode() {
        repository = mock(ProductRepository.class);
        ProductServiceImpl service = new ProductServiceImpl(repository);

        when(repository.findByCode("A555")).thenReturn(new ArrayList<>());
        List<Product> result = service.getAllByCode("A555");

        assertNotNull(result);

        assertEquals(0,result.size());
    }
}