package com.UserProfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserProfile.model.Profile;

@Repository
public interface UserRepository extends JpaRepository<Profile, Long>{
	

}
