package com.product.external.services;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.product.model.User;


@FeignClient(name="USER-SERVICE", url="http://localhost:8081") 
public interface UserService {

	

     // Endpoint in the user microservice to retrieve all users
	    @GetMapping("/auth/getUserById/{userId}")
	    ResponseEntity<?> getUserById(@PathVariable int userId);

	    @GetMapping(path = "/auth/getAllUsers")
	    public ResponseEntity<?> getAllUsers();
}
