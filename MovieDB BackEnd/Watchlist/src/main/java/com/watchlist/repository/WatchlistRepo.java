package com.watchlist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.watchlist.model.Watchlist;

@Repository
public interface WatchlistRepo extends JpaRepository<Watchlist, Integer>{

	@Query("SELECT w FROM Watchlist w WHERE w.userName = ?1")
	public List<Watchlist> findByUserName(String userName);
	
    @Query("SELECT w FROM Watchlist w WHERE w.userName = ?1 AND w.movieId = ?2")
	public Watchlist findByUserNameAndMovieId(String userName, Integer movieId);
}
