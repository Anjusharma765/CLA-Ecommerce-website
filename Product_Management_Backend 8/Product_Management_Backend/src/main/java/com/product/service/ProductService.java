package com.product.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.model.Product;

public interface ProductService {

 public Product saveProduct(Product product);
 public List<Product>getAllProduct();
 public Product getProductById(int id);
 public String deleteProduct(int id);
 public Product updateProduct(Product product,int id);
 InputStream getResource(String path,String fileName) throws FileNotFoundException;
}
