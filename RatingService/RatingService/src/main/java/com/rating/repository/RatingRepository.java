package com.rating.repository;

import org.springframework.stereotype.Repository;

import com.rating.model.Rating;

//RatingRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
