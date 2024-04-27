package com.art.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    
    private int id;
    private String productName;
    private String description;
    private double price;
    private String status;
    private String imageFilename;
    private Product product;
   
	
	
}
