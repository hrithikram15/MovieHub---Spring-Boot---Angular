package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer>{
	
	@Query("SELECT m FROM Movie m WHERE m.genre = ?1")
	public List<Movie> getMoviesByGenre(String genre);
	
	public List<Movie> findByMovieNameContainingIgnoreCase(String movieName);

}
