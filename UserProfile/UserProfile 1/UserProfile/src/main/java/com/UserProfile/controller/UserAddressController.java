package com.UserProfile.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserProfile.model.UserAddress;
import com.UserProfile.service.UserAddressService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://localhost:3000/")
public class UserAddressController {
	
	@Autowired
	UserAddressService userAddressService;

   
   /* public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }*/

    @GetMapping("/getAll")
    public ResponseEntity<List<UserAddress>> getAllUserAddresses() {
        List<UserAddress> userAddresses = userAddressService.getAllUserAddresses();
        return new ResponseEntity<>(userAddresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAddress> getUserAddressById(@PathVariable Long id) {
        UserAddress userAddress = userAddressService.getUserAddressById(id);
        if (userAddress != null) {
            return new ResponseEntity<>(userAddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<UserAddress> saveUserAddress(@RequestBody UserAddress userAddress) {
        UserAddress savedUserAddress = userAddressService.saveUserAddress(userAddress);
        return new ResponseEntity<>(savedUserAddress, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserAddress(@PathVariable Long id) {
        userAddressService.deleteUserAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
