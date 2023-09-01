package com.rating.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rating.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>{
	
	public List<Rating> findByUserName(String userName);
	
	public List<Rating> findByMovieId(Integer movieId);
	
	  @Query("SELECT r FROM Rating r WHERE r.userName = ?1 AND r.movieId = ?2")
		public Optional<Rating> findByUserNameAndMovieId(String userName, Integer movieId);

}
