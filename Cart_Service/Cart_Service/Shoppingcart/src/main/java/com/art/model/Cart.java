package com.art.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shopping_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    private int productId;
    private double totalPrice;
   
    
   @Min(value = 0, message = "Quantity must be greater than or equal to zero")
    private int quantity;
    
   @Min(value = 0, message = "Price must be greater than or equal to zero")
    private double price;

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = quantity * price;
    }
  
   

}
