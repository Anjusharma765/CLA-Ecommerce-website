//package com.UserProfile.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.UserProfile.model.Order;
//import com.UserProfile.service.OrderService;
//
//@RestController
//@RequestMapping("/api/orders")
//@CrossOrigin(origins="http://localhost:3000/")
//public class OrderController {
//
//	
//	 @Autowired
//	 OrderService orderService;
//
//	    
//	    /*public OrderController(OrderService orderService) {
//	        this.orderService = orderService;
//	    }*/
//
//	    @GetMapping
//	    public ResponseEntity<List<Order>> getAllOrders() {
//	        List<Order> orders = orderService.getAllOrders();
//	        return new ResponseEntity<>(orders, HttpStatus.OK);
//	    }
//	
//}

