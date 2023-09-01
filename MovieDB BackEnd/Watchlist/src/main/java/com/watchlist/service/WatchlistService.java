package com.watchlist.service;

import java.util.List;

import com.watchlist.model.Watchlist;


public interface WatchlistService {
	public List<Watchlist> getWatchlistDetails(String userName);
	
	public Watchlist addToWatchlist(Integer movieId, String userName);
	
	public void deleteWatchlistItem(Integer watchListId);
	
	public void deleteMovie(String userName, Integer movieId);

}
