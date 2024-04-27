package com.UserProfile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserProfile.model.UserAddress;
import com.UserProfile.repository.UserAddressRepository;

@Service
public class UserAddressServiceImpl implements UserAddressService{
    
	@Autowired
	UserAddressRepository userAddressRepository;
	
	
   /* public UserAddressServiceImpl(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }*/
	   
	    public List<UserAddress> getAllUserAddresses() {
	        return userAddressRepository.findAll();
	    }
	 
	   
	    public UserAddress getUserAddressById(Long id) {
	        return userAddressRepository.findById(id).get();
	    }

	    
	    public UserAddress saveUserAddress(UserAddress userAddress) {
	        return userAddressRepository.save(userAddress);
	    }

	    
	    public void deleteUserAddress(Long id) {
	        userAddressRepository.deleteById(id);
	    }


		
}
