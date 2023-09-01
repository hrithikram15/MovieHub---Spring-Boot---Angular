package com.movie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue
	private Integer movieId;
	private String movieName;
	private String yor;
	private String cast;
	private String director;
	private String production;
	private String genre;
	private String budget;
	private String boCollection;
	private String plot;
	private String imageURL;
	private Integer rating;
	private String language;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(Integer movieId, String movieName, String yor, String cast, String director, String production,
			String genre, String budget, String boCollection, String plot, String imageURL, Integer rating, String language) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.yor = yor;
		this.cast = cast;
		this.director = director;
		this.production = production;
		this.genre = genre;
		this.budget = budget;
		this.boCollection = boCollection;
		this.plot = plot;
		this.imageURL = imageURL;
		this.rating = rating;
		this.language = language;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getYor() {
		return yor;
	}
	public void setYor(String yor) {
		this.yor = yor;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getBoCollection() {
		return boCollection;
	}
	public void setBoCollection(String boCollection) {
		this.boCollection = boCollection;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	

}
