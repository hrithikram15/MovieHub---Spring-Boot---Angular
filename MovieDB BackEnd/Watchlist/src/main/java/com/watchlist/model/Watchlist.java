package com.watchlist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Watchlist {
	
	@Id
	@GeneratedValue
	private Integer watchListId;
	private Integer movieId;
	private String userName;

	
	public Watchlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Watchlist(Integer watchListId, Integer movieId, String userName) {
		super();
		this.watchListId = watchListId;
		this.movieId = movieId;
		this.userName = userName;
	}
	
	public Watchlist(Integer movieId, String userName) {
		super();
	
		this.movieId = movieId;
		this.userName = userName;
	}
	
	
	public Integer getWatchListId() {
		return watchListId;
	}
	public void setWatchListId(Integer watchListId) {
		this.watchListId = watchListId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
