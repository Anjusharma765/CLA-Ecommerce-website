package com.rating.service;

import java.util.List;
import java.util.Optional;

//RatingService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.model.Rating;
import com.rating.repository.RatingRepository;

@Service
public class RatingService {

 private final RatingRepository ratingRepository;

 @Autowired
 public RatingService(RatingRepository ratingRepository) {
     this.ratingRepository = ratingRepository;
 }

 public Rating addRating(Rating rating) {
     return ratingRepository.save(rating);
 }
 // Method to fetch a rating by its ID from the database
 public Rating getRatingById(Long id) {
     return ratingRepository.findById(id).get();
 }

 public List<Rating> getAllRatings() {
     return ratingRepository.findAll();
 }
}

