package com.UserProfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserProfile.model.UserAddress;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long>{

}
