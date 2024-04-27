package com.UserProfile.service;

import java.util.List;

import com.UserProfile.model.UserAddress;

public interface UserAddressService {
	List<UserAddress> getAllUserAddresses();
    UserAddress getUserAddressById(Long id);
    UserAddress saveUserAddress(UserAddress userAddress);
    void deleteUserAddress(Long id);

}
