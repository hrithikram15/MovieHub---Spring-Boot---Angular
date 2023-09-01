import { Injectable } from '@angular/core';
import { Movie } from '../all-movies/Movie';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MovieServiceService {

  constructor(private httpClient: HttpClient) { }

  public getMovies(){
    return this.httpClient.get<Movie[]>("http://localhost:9096/movie/getAllMovies");
  }

  public getTopRatedMovies(){
    return this.httpClient.get<Movie[]>("http://localhost:9096/movie/getTopRatedMovies");
  }

  public getMovieById(movieId: number){
    return this.httpClient.get("http://localhost:9096/movie/getMovie/" + movieId);
   }

   public getMoviesByGenre(genre: string){
    return this.httpClient.get<Movie[]>("http://localhost:9096/movie/getMoviesByGenre/" + genre);
   }

   public getWatchlistDetails(username: string){
    return this.httpClient.get<any[]>("http://localhost:9097/watchlist/getWatchlistDetails/" + username);
   }

   public deleteWatchlistItem(userName: string, movieId: number){
    return this.httpClient.delete("http://localhost:9097/watchlist/deleteMovieFromWatchlist/"+userName + "/" + movieId);
   }

   public addMovieToWatchlist(movieId:number, userName: string | String){
    return this.httpClient.get("http://localhost:9097/watchlist/addToWatchlist/" + movieId + "/"+ userName);
  }

  public addReview(rObj: any, userName: string, movieId: number){
    return this.httpClient.post("http://localhost:9095/rating/addRating/" + userName + "/"  + movieId, rObj)
  }

  public checkUserReview(userName: string, movieId: number){
    return this.httpClient.get("http://localhost:9095/rating/checkUserReview/" + userName + "/"  + movieId);
  }

  public getMovieReviews(movieId:number){
    return this.httpClient.get("http://localhost:9095/rating/movie/" + movieId)
  }

  public getUserReviews(userName:string){
    return this.httpClient.get("http://localhost:9095/rating/user/" + userName)
  }


  public deleteRating(ratingId:number){
    return this.httpClient.delete("http://localhost:9095/rating/deleteRating/" + ratingId)
  }

  public searchMovie(movieName:string){
    return this.httpClient.get<Movie[]>("http://localhost:9096/movie/search/" + movieName )
  }

  public addNewMovie(mObj: any){
    return this.httpClient.post("http://localhost:9096/movie/addMovie",mObj);

  }

  public deleteMovie(movieId: number){
    return this.httpClient.delete("http://localhost:9096/movie/deleteMovie/"+movieId);
   }

   public updateMovie(mObj: any, movieId: number){
    return this.httpClient.put("http://localhost:9096/movie/updateMovie/" + movieId , mObj);

  }


}
