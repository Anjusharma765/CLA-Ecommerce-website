package com.art.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.art.exception.CartNotFoundException;
import com.art.exception.ResourceNotFound;
import com.art.model.Cart;
import com.art.model.Product;
import com.art.proxy.ProductService;
import com.art.repository.CartRepository;
import com.art.service.CartServiceImpl;

public class Shoppingcart {

    @Mock
    private CartRepository cartRepository;
    
    @Mock
    private ProductService productProxy;
    
    @InjectMocks
    private CartServiceImpl cartService;
    
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testAddProductToCart_Success() {
        Cart cart = new Cart();
        cart.setProductId(1);
        cart.setQuantity(2);
        
        Product product = new Product();
        product.setPrice(100.00);
        
        when(productProxy.getProductById(1)).thenReturn(product);
        when(cartRepository.save(any())).thenReturn(cart);
        
        Cart result = cartService.addProductToCart(cart);
        
        assertEquals(cart.getProductId(), result.getProductId());
        assertEquals(cart.getQuantity(), result.getQuantity());
        assertEquals(cart.getTotalPrice(), 200.00);
    }
    
    @Test
    public void testAddProductToCart_ProductNotFound() {
        Cart cart = new Cart();
        cart.setProductId(1);
        
        when(productProxy.getProductById(1)).thenThrow(CartNotFoundException.class);
        
        Cart result = cartService.addProductToCart(cart);
        
        assertEquals(null, result);
    }
    
    @Test
    public void testDeleteProductFromCart_Success() {
        int productId = 1;
        Cart cart = new Cart();
        cart.setProductId(productId);
        
        Optional<Cart> optionalCart = Optional.of(cart);
        
        when(cartRepository.findByProductId(productId)).thenReturn(optionalCart);
        
        String result = cartService.deleteProductFromCart(productId);
        
        assertEquals("Product Deleted Successfully", result);
    }
    
    @Test
    public void testDeleteProductFromCart_CartItemNotFound() {
        int productId = 1;
        Optional<Cart> optionalCart = Optional.empty();
        
        when(cartRepository.findByProductId(productId)).thenReturn(optionalCart);
        
        try {
            cartService.deleteProductFromCart(productId);
        } catch (CartNotFoundException e) {
            assertEquals("Product not found with ID: " + productId, e.getMessage());
        }
    }
    
    // Add more test cases as needed
    @Test
    public void testUpdateCart_Success() {
        int productId = 1;
        int quantity = 2;
        Cart existingCart = new Cart();
        existingCart.setProductId(productId);
        existingCart.setQuantity(3);
        existingCart.setPrice(100.00);
        
        Optional<Cart> optionalCart = Optional.of(existingCart);
        
        when(cartRepository.findByProductId(productId)).thenReturn(optionalCart);
        when(cartRepository.save(any())).thenReturn(existingCart);
        
        Cart result = cartService.updateCart(productId, quantity);
        
        assertEquals(productId, result.getProductId());
        assertEquals(5, result.getQuantity());
        assertEquals(500.00, result.getTotalPrice());
    }
    
    @Test
    public void testUpdateCart_ProductNotFound() {
        int productId = 1;
        int quantity = 2;
        
        Optional<Cart> optionalCart = Optional.empty();
        
        when(cartRepository.findByProductId(productId)).thenReturn(optionalCart);
        
        assertThrows(ResourceNotFound.class, () -> {
            cartService.updateCart(productId, quantity);
        });
    }
    
    @Test
    public void testGetTotalPrice_Success() {
        int productId = 1;
        Cart cart = new Cart();
        cart.setProductId(productId);
        cart.setQuantity(3);
        cart.setPrice(100.00);
        
        Optional<Cart> optionalCart = Optional.of(cart);
        
        when(cartRepository.findByProductId(productId)).thenReturn(optionalCart);
        
        double totalPrice = cartService.getTotalPrice(productId);
        
        assertEquals(300.00, totalPrice);
    }
    
    @Test
    public void testGetTotalPrice_CartNotFound() {
        int productId = 1;
        
        Optional<Cart> optionalCart = Optional.empty();
        
        when(cartRepository.findByProductId(productId)).thenReturn(optionalCart);
        
        assertThrows(ResourceNotFound.class, () -> {
            cartService.getTotalPrice(productId);
        });
    }
    
}
