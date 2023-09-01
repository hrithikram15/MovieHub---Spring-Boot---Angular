package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.exception.MovieAlreadyExistsException;
import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;
import com.movie.service.MovieServiceImpl;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/movie")
public class MovieController {
	
	private ResponseEntity<?> responseEntity;

	@Autowired
	private MovieServiceImpl movieService;
	

	
	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovieHandler(@RequestBody Movie movie) throws MovieAlreadyExistsException{
		try {
			Movie newMovie = movieService.addMovie(movie);
			this.responseEntity = new ResponseEntity<>(newMovie,HttpStatus.CREATED);
		} catch (MovieAlreadyExistsException exception) {
			throw exception;
		}
		catch(Exception e) {
			System.out.println(e);
			this.responseEntity = new ResponseEntity<>("Some internal error occured..", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return this.responseEntity;
	}
	
	@GetMapping("/getMovie/{mId}")
	public ResponseEntity<?> getMovieByIdHandler(@PathVariable int mId) throws MovieNotFoundException{
		Movie movie = this.movieService.getMovieById(mId);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@GetMapping("/getAllMovies")
	public List<Movie> getAllMoviesHandler(){
		return this.movieService.getAllMovies();
		
	}
	
	@GetMapping("/search/{movieName}")
	public List<Movie> searchMovieHandler(@PathVariable String movieName){
		return this.movieService.searchMovie(movieName);
	}
	
	
	
	@GetMapping("/getTopRatedMovies")
	public List<Movie> getTopRatedMoviesHandler(){
		return this.movieService.getAllMoviesOrderedByRating();
		
	}
	
	@GetMapping("/getMoviesByGenre/{genre}")
	public List<Movie> getMoviesByGenreHandler(@PathVariable String genre){
		return this.movieService.getMoviesByGenre(genre);
		
	}
	
	@PutMapping("/updateMovie/{mId}")
	public ResponseEntity<?> updateMovieHandler(@RequestBody Movie mObj, @PathVariable int mId) throws MovieNotFoundException{
		Movie movie = this.movieService.updateMovie(mObj, mId);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateRating/{mId}")
	public ResponseEntity<?> updateRating(@RequestBody Movie mObj, @PathVariable int mId) throws MovieNotFoundException{
		Movie movie = this.movieService.updateMovie(mObj, mId);
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteMovie/{mId}")
	public ResponseEntity<?> deleteMovieHandler(@PathVariable int mId) throws MovieNotFoundException{
		this.movieService.deleteMovie(mId);
		return new ResponseEntity<>("Movie Deleted Successfully", HttpStatus.OK);
	}

}
