package com.art.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.art.model.Cart;



@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{

	Optional<Cart> findByProductId(int productId);
	

}
