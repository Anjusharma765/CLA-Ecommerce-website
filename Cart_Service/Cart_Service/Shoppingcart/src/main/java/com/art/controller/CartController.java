package com.art.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.art.service.CartService;
import com.art.service.CartServiceImpl;
import com.art.model.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class CartController {

	@Autowired
	private CartServiceImpl cartService;

	@PostMapping("/addToCart")
	public ResponseEntity<Cart> addProductToCart(@RequestBody Cart cart) {
	    Cart result = cartService.addProductToCart(cart);
	    return ResponseEntity.ok().body(result);
	}


	@GetMapping("/getAllProductsInCart")
	public List<Cart> getAllProductsInCart() {
		return cartService.getAllProductInCart();
	}

	@DeleteMapping("/deleteProductFromCart/{productId}")
    public String deleteProductFromCart(@PathVariable int productId) {
        return cartService.deleteProductFromCart(productId);
    }

	@PutMapping("/updateCart/{productId}")
    public Cart updateCart(@PathVariable int productId, @RequestParam int quantity) {
        return cartService.updateCart(productId, quantity);
    }

	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable int id) {
		return cartService.getProductById(id);
	}
	@GetMapping("/cart/totalPrice/{productId}")
    public double getTotalPrice(@PathVariable int productId)
    {
		return cartService.getTotalPrice(productId);
    }

}
