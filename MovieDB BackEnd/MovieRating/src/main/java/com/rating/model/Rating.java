package com.rating.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Rating {
	
	public Rating(String userName, Integer movieId, Integer rating, String review) {
		super();
		this.userName = userName;
		this.movieId = movieId;
		this.rating = rating;
		this.review = review;
	}
	@Id
	@GeneratedValue
	private Integer ratingId;
	
	private String userName;
	private Integer movieId;
	private Integer rating;
	private String review;
	
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(Integer ratingId, String userName, Integer movieId, Integer rating, String review) {
		super();
		this.ratingId = ratingId;
		this.userName = userName;
		this.movieId = movieId;
		this.rating = rating;
		this.review = review;
	}
	public Integer getRatingId() {
		return ratingId;
	}
	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getProductId() {
		return movieId;
	}
	public void setProductId(Integer movieId) {
		this.movieId = movieId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	

}
