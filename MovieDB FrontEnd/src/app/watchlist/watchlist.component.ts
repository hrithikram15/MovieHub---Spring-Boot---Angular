import { Component } from '@angular/core';
import { Movie } from '../all-movies/Movie';
import { MovieServiceService } from '../services/movie-service.service';
import { Router } from '@angular/router';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-watchlist',
  templateUrl: './watchlist.component.html',
  styleUrls: ['./watchlist.component.css']
})
export class WatchlistComponent {
  currentUser: any;

  displayedColumns: string[] = ['movieName', 'genre', 'director' , 'production' ,'action'];
  watchlistDetails : any[] = [];
  movieDetails : Movie[] = [];


   userName : any = "hmk";

  constructor(private movieService : MovieServiceService,
    private router : Router, private tokenStorageService: TokenStorageService,
    private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.userName = localStorage.getItem('name');
    console.log(this.userName)
    this.getWatchlistDetails(this.userName);
  }



  delete(movieId: number){
    console.log(movieId)
    this.movieService.deleteWatchlistItem(this.userName, movieId).subscribe(
      (resp) => {
        console.log(resp);
        this.getWatchlistDetails(this.userName);

      },(error) =>{
        console.log(error);
      }
    )
  }

  getWatchlistDetails(userName: string) {
    this.movieService.getWatchlistDetails(userName).subscribe(
      (response: any[]) => {
        console.log(response);
        this.watchlistDetails = response;
        const movieIds = this.watchlistDetails.map(item => item.movieId);
        this.getMovieDetailsForUserWatchlist(movieIds);
      },
      (error) => {
        console.log(error);
      }
    );
  }
  
  getMovieDetailsForUserWatchlist(movieIds: any[]) {
    this.movieDetails = []; // Clear the existing productDetails array
    for (const movieId of movieIds) {
      this.movieService.getMovieById(movieId).subscribe(
        (response: any) => {
          this.movieDetails.push(response);
        },
        (error) => {
          console.log(error);
        }
      );
    }
    console.log(this.movieDetails);
    console.log(this.movieDetails[0].movieName);


  }
  

}
