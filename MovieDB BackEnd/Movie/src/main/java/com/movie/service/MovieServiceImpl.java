package com.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.exception.MovieAlreadyExistsException;
import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;
import com.movie.repository.MovieRepo;


@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepo movieRepo;

	@Override
	public Movie addMovie(Movie mObj) throws MovieAlreadyExistsException {
		// TODO Auto-generated method stub
		Optional<Movie> optional = this.movieRepo.findById(mObj.getMovieId());
		Movie addObj = null;
		
		if(optional.isPresent()) {
			System.out.println("Movie Details already exists ...");
			throw new MovieAlreadyExistsException();

		}else {
			addObj = this.movieRepo.save(mObj);
		}
		return addObj;
	}

	@Override
	public Movie updateMovie(Movie mObj, int mId) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> optional = this.movieRepo.findById(mId);
		Movie mobj = null;
		Movie updatedData = null;
		
		if(optional.isPresent()) {
			System.out.println("Can update the product ...");
			mobj = optional.get();
			
			mobj.setMovieName(mObj.getMovieName());
			mobj.setCast(mObj.getCast());
			mobj.setDirector(mObj.getDirector());
			mobj.setProduction(mObj.getProduction());
			mobj.setBudget(mObj.getBudget());
			mobj.setBoCollection(mObj.getBoCollection());
			mobj.setGenre(mObj.getGenre());
			mobj.setImageURL(mObj.getImageURL());
			mobj.setPlot(mObj.getPlot());
			mobj.setRating(mObj.getRating());
			mobj.setYor(mObj.getYor());
			mobj.setLanguage(mObj.getLanguage());
			
			updatedData = this.movieRepo.save(mobj);

		}else {
			throw new MovieNotFoundException();
		}
		return updatedData;
	}

	@Override
	public Movie getMovieById(int mId) throws MovieNotFoundException {
Optional<Movie> optional = this.movieRepo.findById(mId);
		
		Movie obj = null;
		
		if(optional.isPresent()) {
			obj = optional.get();
		}else {
			throw new MovieNotFoundException();
		}
				return obj;
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return this.movieRepo.findAll();
	}

	@Override
	public boolean deleteMovie(int mId) throws MovieNotFoundException {
		Optional<Movie> optional = this.movieRepo.findById(mId);

		boolean status = false;
		
		if(optional.isPresent()) {
        	System.out.println("Movie Found and ready for Delete !!!");
        	this.movieRepo.deleteById(mId);
        	status = true;

		}else {
			throw new MovieNotFoundException();
		}
		return status;
	}

	@Override
	public List<Movie> getMoviesByGenre(String genre) {
		// TODO Auto-generated method stub
		return this.movieRepo.getMoviesByGenre(genre);
	}
	
	@Override
	 public List<Movie> getAllMoviesOrderedByRating() {
	        List<Movie> allMovies = this.movieRepo.findAll();
	        
	        List<Movie> sortedMovies = allMovies.stream()
	                .sorted((m1, m2) -> m2.getRating().compareTo(m1.getRating()))
	                .collect(Collectors.toList());

	        return sortedMovies;
	    }
	

	@Override
	public Movie updateRating(Movie mObj, int mId) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> optional = this.movieRepo.findById(mId);
		Movie mobj = null;
		Movie updatedData = null;
		
		if(optional.isPresent()) {
			System.out.println("Can update the product ...");
			mobj = optional.get();
			
			
			mobj.setRating(mObj.getRating());
			
			
			updatedData = this.movieRepo.save(mobj);

		}else {
			throw new MovieNotFoundException();
		}
		return updatedData;
		}

	@Override
	public List<Movie> searchMovie(String movieName) {
		System.out.println("movie:" + movieName);
		
		return this.movieRepo.findByMovieNameContainingIgnoreCase(movieName);
			}

}
