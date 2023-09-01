package com.watchlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.watchlist.model.Watchlist;
import com.watchlist.service.WatchlistServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/watchlist")
public class WatchlistController {
	
	@Autowired
	private WatchlistServiceImpl watchlistService;
	
	@GetMapping({"/addToWatchlist/{movieId}/{userName}"})
	public Watchlist addTocart(@PathVariable(name="movieId") Integer movieId, @PathVariable(name="userName") String userName) {
		return watchlistService.addToWatchlist(movieId, userName);
		
	}
	
	@DeleteMapping({"/deleteWatchlistItem/{watchListId}"})
	public void deleteWatchlistItem(@PathVariable(name= "watchListId") Integer watchListId) {
		watchlistService.deleteWatchlistItem(watchListId);		
	}
	
	@DeleteMapping({"/deleteMovieFromWatchlist/{userName}/{movieId}"})
	public void deleteMovieFromWatchlist(@PathVariable(name= "userName") String userName, @PathVariable(name= "movieId") Integer movieId) {
		watchlistService.deleteMovie(userName, movieId);		
	}
	
	@GetMapping({"/getWatchlistDetails/{userName}"})
	public List<Watchlist> getWatchlistDetails(@PathVariable String userName) {
		return watchlistService.getWatchlistDetails(userName);
		
	}
	

}
