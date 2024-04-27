package com.UserProfile.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.UserProfile.external.ProfileServiceFeignClient;
import com.UserProfile.model.Profile;
import com.UserProfile.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")

@CrossOrigin(origins="http://localhost:3000/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
//	public UserController(UserService userService) {
//		this.userService = userService;
//	}//
	
	
	@PostMapping("/createUser")
    public ResponseEntity<Profile> createUser(@RequestBody Profile user) {
        Profile savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
	
   
		
	/*@PutMapping("/password/{userId}")
    public ResponseEntity<Profile> updateUserPassword(@PathVariable Long userId,
                                                     String oldPassword,
                                                    @RequestParam("newPassword") String newPassword) {
        Profile updatedUser = userService.updateUserPassword(userId, oldPassword, newPassword);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            // Handle errors such as user not found or incorrect old password
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
	

	@GetMapping("/view/{userId}")
	  public ResponseEntity<?> getUserById(@PathVariable int userId){
		  return userService.getUserInProduct(userId);
	  }

}
