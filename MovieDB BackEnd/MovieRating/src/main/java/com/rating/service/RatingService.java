package com.rating.service;

import java.util.List;

import com.rating.exception.UserReviewAlreadyExistsException;
import com.rating.model.Rating;

public interface RatingService {
	
	public List<Rating> getAllReviewsByProduct(Integer productId);
	
	public List<Rating> getAllReviewsByUserName(String userName);

	
	public Rating addReview(Rating rating, String userName, Integer productId) throws UserReviewAlreadyExistsException;
	
	public Rating updateReview(Rating rating, String userName, Integer productId);
	
	public void deleteReview(Integer ratingId);
	
	public boolean checkUserReview(String userName, Integer movieId);

	

}
