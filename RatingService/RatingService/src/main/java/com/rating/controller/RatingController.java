package com.rating.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rating.model.Rating;
import com.rating.service.RatingService;

import java.util.List;
import java.util.Optional;

//RatingController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class RatingController {

 private final RatingService ratingService;

 @Autowired
 public RatingController(RatingService ratingService) {
     this.ratingService = ratingService;
 }

 @PostMapping("/ratings")
 public ResponseEntity<String> addRating(@RequestBody Rating rating) {
     ratingService.addRating(rating);
     return ResponseEntity.status(HttpStatus.CREATED).body("Rating added successfully");
 }
 @GetMapping("/{id}")
 public Rating getRatingById(@PathVariable Long id) {
     return ratingService.getRatingById(id);
 }
 @GetMapping("/ratings")
 public List<Rating> getAllRatings() {
     return ratingService.getAllRatings();
 }
}
