package com.rating.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.exception.UserReviewAlreadyExistsException;
import com.rating.model.Rating;
import com.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepo;

	@Override
	public List<Rating> getAllReviewsByProduct(Integer movieId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByMovieId(movieId);
	}

	@Override
	public List<Rating> getAllReviewsByUserName(String userName) {
		// TODO Auto-generated method stub
		return ratingRepo.findByUserName(userName);
	}

	@Override
	public Rating addReview(Rating rating, String userName, Integer movieId) throws UserReviewAlreadyExistsException {
		
		Optional<Rating> rOld = ratingRepo.findByUserNameAndMovieId(userName, movieId);
		
		if(rOld.isPresent()) {
			System.out.println("User review alreday exists");
			throw new UserReviewAlreadyExistsException();
			
		}else {
			Rating rObj = new Rating(userName, movieId, rating.getRating(), rating.getReview());
			return ratingRepo.save(rObj);
			
		}
		
		
	}

	@Override
	public Rating updateReview(Rating rating, String userName, Integer movieId) {
		// TODO Auto-generated method stub
		
		Rating rObj = new Rating(userName, movieId, rating.getRating(), rating.getReview());
		return ratingRepo.save(rObj);
	}

	@Override
	public void deleteReview(Integer ratingId) {
		// TODO Auto-generated method stub
		 ratingRepo.deleteById(ratingId);
		
	}

	@Override
	public boolean checkUserReview(String userName, Integer movieId) {
		System.out.println("--> "+userName+" "+movieId);
		Optional<Rating> rOld = ratingRepo.findByUserNameAndMovieId(userName, movieId);
		if(rOld.isPresent()) {
			return true;
		}
			return false;

		
	}

	

}
