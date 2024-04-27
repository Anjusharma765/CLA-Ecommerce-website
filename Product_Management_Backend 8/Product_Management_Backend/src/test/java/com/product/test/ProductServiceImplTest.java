package com.product.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.product.model.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductServiceImpl;
import com.product.external.services.UserService;

@SpringBootTest
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void testSaveProduct() {
        // Prepare
        Product product = new Product();
        product.setId(1);
        product.setProductName("Test Product");
        product.setPrice(100);

        when(productRepository.save(product)).thenReturn(product);

        // Test
        Product savedProduct = productService.saveProduct(product);

        // Verify
        assertEquals(product, savedProduct);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testGetAllProduct() {
        // Prepare
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());

        when(productRepository.findAll()).thenReturn(productList);

        // Test
        List<Product> result = productService.getAllProduct();

        // Verify
        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    

    @Test
    public void testDeleteProduct() {
        // Prepare
        Product product = new Product();
        product.setId(1);
        product.setProductName("Test Product");
        product.setPrice(100);

        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // Test
        String result = productService.deleteProduct(1);

        // Verify
        assertEquals("Product Deleted Successfully", result);
        verify(productRepository, times(1)).delete(product);
    }

    @Test
    public void testUpdateProduct() {
        // Prepare
        Product existingProduct = new Product();
        existingProduct.setId(1);
        existingProduct.setProductName("Existing Product");
        existingProduct.setPrice(100);

        Product updatedProduct = new Product();
        updatedProduct.setId(1);
        updatedProduct.setProductName("Updated Product");
        updatedProduct.setPrice(200);

        when(productRepository.findById(1)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(existingProduct)).thenReturn(updatedProduct);

        // Test
        Product result = productService.updateProduct(updatedProduct, 1);

        // Verify
        assertEquals(updatedProduct, result);
        verify(productRepository, times(1)).findById(1);
        verify(productRepository, times(1)).save(existingProduct);
    }


 
   

   
}

