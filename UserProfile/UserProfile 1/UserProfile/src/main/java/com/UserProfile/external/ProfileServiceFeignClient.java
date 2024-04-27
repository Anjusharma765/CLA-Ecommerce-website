package com.UserProfile.external;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



import jakarta.validation.Valid;

@FeignClient(name="USER-SERVICE", url="http://localhost:8081") 
public interface ProfileServiceFeignClient {
	
	// Endpoint in the user microservice to retrieve all users
    
    
	@GetMapping("/auth/getUserById/{userId}")
    ResponseEntity<?> getUserById(@PathVariable int userId);
	
	 
	
	
    
}


