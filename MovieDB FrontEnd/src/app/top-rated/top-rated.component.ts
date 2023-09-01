import { Component } from '@angular/core';
import { Movie } from '../all-movies/Movie';
import { MovieServiceService } from '../services/movie-service.service';
import { Router } from '@angular/router';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-top-rated',
  templateUrl: './top-rated.component.html',
  styleUrls: ['./top-rated.component.css']
})
export class TopRatedComponent {

  displayedColumns: string[] = ['Rank', 'movieName', 'director', 'cast' , 'rating', 'Actions'];
  topRatedMoviesList: Movie[] = [];

  userName : any = "hmk";
  currentUser: any;


  constructor(private movieService: MovieServiceService, private router: Router, private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.userName = localStorage.getItem('name');
    console.log(this.userName)
    this.getTopRatedMovies();

  }
  getTopRatedMovies(){
    this.movieService.getTopRatedMovies().subscribe(data => {
      this.topRatedMoviesList = data;
      console.log(this.topRatedMoviesList)
      console.log(this.topRatedMoviesList[0].movieName)
    });
  }

  

  addToWatchList(movieId: number){
    console.log(movieId);

    this.movieService.addMovieToWatchlist(movieId, this.userName).subscribe(
      (data: any)=>{
      console.log(data);

      this.router.navigate(['/watchlist']);


    },
  (error: any) => {
    console.log(error);
  })

  }

}
