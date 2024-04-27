package com.UserProfile.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.UserProfile.external.ProfileServiceFeignClient;
//import com.UserProfile.external.ProfileServiceFeignClient;
import com.UserProfile.model.Profile;
import com.UserProfile.repository.UserRepository;




@Service
public class UserService {
	
	@Autowired
	 UserRepository userRepository;
	
	@Autowired
	ProfileServiceFeignClient profile;
	
	
	public ResponseEntity<?> getUserInProduct(int userId){
		return profile.getUserById(userId);
	}
//	public UserService(UserRepository userRepository) {
//		this.userRepository = userRepository;
//		
//	
//	}
	
	public Profile saveUser(Profile user) {
		return userRepository.save(user);
	}
	
	/*public Profile updateUserPassword(Long userId, String oldPassword, String newPassword) {
        Profile user = userRepository.findById(userId).get();
        if (user == null) {
            // Handle user not found
            return null;
        }
        if (!user.getPassword().equals(oldPassword)) {
            // Handle incorrect old password
            return null;
        }
        user.setPassword(newPassword);
        return userRepository.save(user);
    }
	*/

}

