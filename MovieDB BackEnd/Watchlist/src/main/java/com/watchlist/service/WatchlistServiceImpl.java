package com.watchlist.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watchlist.model.Watchlist;
import com.watchlist.repository.WatchlistRepo;

@Service
public class WatchlistServiceImpl implements WatchlistService{
	
	@Autowired
	private WatchlistRepo watchlistRepo;

	@Override
	public List<Watchlist> getWatchlistDetails(String userName) {
		return watchlistRepo.findByUserName(userName);
	}

	@Override
	public Watchlist addToWatchlist(Integer movieId, String userName) {
		List<Watchlist> watchList = watchlistRepo.findByUserName(userName);
		List<Watchlist> filteredList = watchList.stream().filter(x -> x.getMovieId() == movieId).collect(Collectors.toList());
		
		if(filteredList.size() > 0) {
			return null;
		}
		
		
		
		Watchlist watchlist = new Watchlist(movieId, userName);
			return watchlistRepo.save(watchlist);
		
	}

	@Override
	public void deleteWatchlistItem(Integer watchListId) {
		watchlistRepo.deleteById(watchListId);
	}

	@Override
	public void deleteMovie(String userName, Integer movieId) {
		Watchlist userWatchlist = watchlistRepo.findByUserNameAndMovieId(userName, movieId);
		watchlistRepo.deleteById(userWatchlist.getWatchListId());
	}

}
