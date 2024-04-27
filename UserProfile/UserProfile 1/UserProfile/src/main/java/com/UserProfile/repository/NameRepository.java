package com.UserProfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserProfile.model.changeName;

public interface NameRepository extends JpaRepository<changeName, Long>{

}
