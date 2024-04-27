package com.art.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import com.art.proxy.ProductService;
//import com.art.proxy.UserProxy;

import com.art.repository.CartRepository;
import com.art.exception.ResourceNotFound;

import com.art.model.Product;

import lombok.extern.slf4j.Slf4j;

import com.art.exception.CartNotFoundException;
import com.art.exception.ResourceNotFound;
import com.art.model.*;
//import com.art.model.product.Product;
// com.art.model.product.Product;


@Service
@Slf4j
public class CartServiceImpl implements CartService {
    
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
    
    @Autowired
    private CartRepository cartRepository;
    
   
    
   //@Autowired
   // private UserProxy userProxy;
    
    @Autowired
    private ProductService productProxy;
    
   /* @Override
    public void addProductToCart(int cartId, int productId, int quantity) {
        try {
            logger.info("Adding product with ID {} to cart with ID {}", productId, cartId);
            Product product = getProductById(productId); // Assuming getProductById(int id) method is available

            Cart cart = new Cart();
            cart.setCartId(cartId);
            cart.setProductId(productId);
            cart.setQuantity(quantity);
            cart.setTotalPrice(quantity);

            cartRepository.save(cart);
            logger.info("Product added to cart successfully");
        } catch (CartNotFoundException e) {
            throw e;
        } catch (Exception e) {
            logger.error("Error occurred while adding product to cart", e);
            throw new CartNotFoundException("Failed to add product to cart");
        }
    }*/
    
   // @Autowired
  // private  UserProxy userservice;
    
   
    
    

   
   /* @Override
    
    public Product getProductById(@PathVariable int id) {
        try {
            logger.info("Fetching product with ID: {}", id);
            Product responseEntity = productProxy.getProductById(id);
            return responseEntity;
        } catch (Exception e) {
            logger.error("Error occurred while fetching product with ID: {}", id, e);
            throw new CartNotFoundException("Product with ID " + id + " not found");
        }
    }



   
    public void addProductToCart(long cartId, int id, int quantity) {
        try {
            logger.info("Adding product with ID {} to cart with ID {}", id, cartId);
            Product product = getProductById(id); // Assuming getProductById(int id) method is available

            Cart cart = new Cart();
            cart.setCartid(cartId);
            cart.setProduct(product);
            cart.setQuantity(quantity);
            cart.setTotalPrice(quantity);

            cartRepository.save(cart);
            logger.info("Product added to cart successfully");
        } catch (CartNotFoundException e) {
            throw e;
        } catch (Exception e) {
            logger.error("Error occurred while adding product to cart", e);
            throw new CartNotFoundException("Failed to add product to cart");
        }
    }

    @Override
    public void removeProductFromCart(int id) {
        Optional<Cart> optionalCart = cartRepository
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cartRepository.delete(cart);
        } else {
            throw new CartNotFoundException("Product with ID " + id + " not found in the cart");
        }
    }

    @Override
    public List<Cart> displayUserCart() {
        return cartRepository.findAll();
    }
}

    @Override
    public void updateCart(int cartId, String productId, int quantity) {
        Optional<Cart> optionalCart = repo.findById(cartId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            if (cart.getProduct().getProductId().equals(productId)) {
                cart.setQuantity(quantity);
                cart.calculateTotalPrice(); // Recalculate total price based on quantity
                repo.save(cart);
                logger.info("Cart updated successfully");
            } else {
                throw new CartNotFoundException("Product with ID " + productId + " not found in the cart");
            }
        } else {
            throw new CartNotFoundException("Cart with ID " + cartId + " not found");
        }
    }

    @Override
    public List<Cart> getUserCart(String productId) {
        Optional<Cart> optionalCart = repo.findByProductProductId(productId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cart.calculateTotalPrice();
            return Collections.singletonList(cart);
        } else {
            String msg = "Cart not found for productId: " + productId;
            logger.error(msg);
            throw new CartNotFoundException(msg);
        }
    }


    @Override
    public double getTotalPrice(int id) {
        Optional<Cart> optionalCart = repo.findByProductProductId(productId);
        
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            return cart.getTotalPrice();
        } else {
            String msg = "Cart not found for productId: " + productId;
            logger.error(msg);
            throw new CartNotFoundException(msg);
        }
    }

    public ResponseEntity<?> getUserInProduct(int userId){
		return userservice.getUserById(userId);
}*/

	
	
	
	/*@Override
	public Cart addProductToCart(Cart cart) {
		// TODO Auto-generated method stub
		Cart result = cartRepository.save(cart);
		return result;
	}*/
    @Override
    public Cart addProductToCart(Cart cart) {
        try {
            // Fetch the product details based on the productId from the database or external service
            Product product = getProductById(cart.getProductId());

            // Set the price of the cart item based on the product's price
            cart.setPrice(product.getPrice());

            // Calculate the total price by multiplying the quantity and price
            cart.setTotalPrice(cart.getQuantity() * cart.getPrice());

            // Save the cart item to the database
            Cart result = cartRepository.save(cart);

            return result;
        } catch (Exception e) {
            // Handle any exceptions (e.g., database errors, product not found)
            // You can log the error and throw a custom exception or return null/empty cart
            // For simplicity, let's log the error and return null
            logger.error("Error adding product to cart", e);
            return null;
        }
    }

    
    /*@Override
    public Cart addProductToCart(Cart cart) {
		// TODO Auto-generated method stub
    	logger.info("added{}",cart);
    
    	Cart result = cartRepository.save(cart);
    	
		return result;
	}*/
/*2
	
	public void addToCart(String productId,int cartId) {
		ResponseEntity<Product>productResponse=restTemplate.getForEntity("http://8080/product/{productId}", Product.class, productId);
	   Product product=productResponse.getBody();
	   Cart cart=new Cart();
	   //Cart cart1 = retrieveShoppingCartFromAnotherMicroservice(cartId);

       // Add the fetched product to the shopping cart
       cart.setProduct(product);

       // Update the shopping cart in your microservice
       updateShoppingCartInYourMicroservice(cart);
   }

	  public void updateShoppingCartInYourMicroservice(Cart cart) {
	        // Fetch the existing shopping cart from the repository
	        Cart existingCart = cartRepo.findById(cart.getCartId()).orElse(null);

	        if (existingCart != null) {
	            // Update the existing cart with the new data
	            existingCart.setCartItems(cart.getCartItems()); // Assuming Cart has a method to set items

	            // Save the updated shopping cart
	            cartRepo.save(existingCart);
	        } else {
	        	System.out.println("Car is empty");
	            // Handle error: cart not found
	            // You can choose to throw an exception, log an error, or handle it in another way
	        }
	    }

*/

	@Override
	public List<Cart> getAllProductInCart() {
		
		return cartRepository.findAll();
	}
	
	
	 @Override
	    public String deleteProductFromCart(int productId) {
	        // Find the cart item by product ID
	        Optional<Cart> optionalCart = cartRepository.findByProductId(productId);
	        
	        // If the cart item exists, delete it
	        if (optionalCart.isPresent()) {
	            cartRepository.delete(optionalCart.get());
	            return "Product Deleted Successfully";
	        } else {
	            // If the cart item doesn't exist, throw an exception or return an appropriate message
	            throw new CartNotFoundException("Product not found with ID: " + productId);
	        }
	 }

	
	@Override
	public Cart updateCart(int productId, int quantity) {
	    Optional<Cart> optionalCart = cartRepository.findByProductId(productId);
	    if (optionalCart.isPresent()) {
	        Cart existingCart = optionalCart.get();
	        // Update quantity and total price
	        existingCart.setQuantity(existingCart.getQuantity() + quantity);
	        existingCart.setTotalPrice(existingCart.getQuantity() * existingCart.getPrice());
	        // Save the updated cart
	        return cartRepository.save(existingCart);
	    } else {
	        // Handle case where product ID is not found
	        throw new ResourceNotFound("Cart", "ProductId", productId);
	    }
	}





	 
	
	public double getTotalPrice(int productId) {
	    Optional<Cart> optionalCart = cartRepository.findByProductId(productId);
	    if (optionalCart.isPresent()) {
	        Cart cart = optionalCart.get();
	        double totalPrice = cart.getPrice() * cart.getQuantity();
	        return totalPrice;
	    } else {
	        // Handle the case where the cart with the specified productId is not found
	        // For example, you can throw an exception or return a default value
	        throw new ResourceNotFound("Cart", "ProductId", productId);
	    }
	}


	public Product getProductById(int id)
	{
		return productProxy.getProductById(id);
	}
	

	
	
}

	

