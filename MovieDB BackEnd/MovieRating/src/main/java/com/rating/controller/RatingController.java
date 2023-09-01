package com.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.exception.UserReviewAlreadyExistsException;
import com.rating.model.Rating;
import com.rating.service.RatingServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingServiceImpl ratingService;
	
	@GetMapping("/user/{userName}")
	public List<Rating> userRatings(@PathVariable String userName){
		return ratingService.getAllReviewsByUserName(userName);
	}
	
	@GetMapping("/movie/{movieId}")
	public List<Rating> productRatings(@PathVariable Integer movieId){
		return ratingService.getAllReviewsByProduct(movieId);
	}
	
	@PostMapping("/addRating/{userName}/{movieId}")
	public Rating addRating(@RequestBody Rating rating, @PathVariable String userName, @PathVariable Integer movieId) throws UserReviewAlreadyExistsException {
		return ratingService.addReview(rating, userName, movieId);
	}
	
	@DeleteMapping("/deleteRating/{ratingId}")
	public void deleteRating(@PathVariable Integer ratingId) {
		ratingService.deleteReview(ratingId);
	}
	
	@GetMapping("/checkUserReview/{userName}/{movieId}")
	public boolean checkUserReviewHandler(@PathVariable String userName, @PathVariable Integer movieId) {
		return ratingService.checkUserReview(userName, movieId);
	}
	
	
	

}
