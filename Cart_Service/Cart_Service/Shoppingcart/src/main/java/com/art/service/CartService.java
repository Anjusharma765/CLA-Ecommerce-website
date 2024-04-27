package com.art.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


//import com.product.model.Product;
import com.art.model.*;
//import com.art.model.product.Product;

public interface CartService {

	
// public void addProductToCart(int cartId, int productId, int quantity);
 public Cart addProductToCart(Cart cart);


 public List<Cart> getAllProductInCart();
 
 public String deleteProductFromCart(int productId);
 public Cart updateCart(int productId, int quantity);
 
 
	

	
}