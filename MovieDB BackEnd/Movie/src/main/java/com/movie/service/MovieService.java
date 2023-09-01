package com.movie.service;

import java.util.List;

import com.movie.exception.MovieAlreadyExistsException;
import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;


public interface MovieService {
	
	public Movie addMovie(Movie mObj) throws MovieAlreadyExistsException;
	public Movie updateMovie(Movie mObj, int mId) throws MovieNotFoundException;
	public Movie updateRating(Movie mObj, int mId) throws MovieNotFoundException;

	public Movie getMovieById(int mId) throws MovieNotFoundException;
	public List<Movie> getAllMovies();
	public boolean deleteMovie(int mId) throws MovieNotFoundException;
	public List<Movie> getMoviesByGenre(String genre);
	public List<Movie> getAllMoviesOrderedByRating();
	
	public List<Movie> searchMovie(String movieName);

	
//	public Product addProduct(Product pObj) throws ProductAlreadyExistsException;
//	public Product updateProduct(Product pObj, int pId) throws ProductNotFoundException;
//	public Product getProductById(int pid) throws ProductNotFoundException;
//	public List<Product> getAllProducts();
//	public boolean deleteProduct(int pid) throws ProductNotFoundException;

}
