import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MovieServiceService } from '../services/movie-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from './Movie';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-all-movies',
  templateUrl: './all-movies.component.html',
  styleUrls: ['./all-movies.component.css']
})
export class AllMoviesComponent implements OnInit{

  movieId: number = 0;
  currentUser: any;

  pattern: string = "";


  userName: any ="hmk";

  moviesList: Movie[] = [];

  topRatedMoviesList: Movie[] = [];


  constructor(private http:HttpClient, private movieService: MovieServiceService, private router : Router, private token: TokenStorageService, private route: ActivatedRoute ) { }

  ngOnInit(): void {
    // this.getProducts();
    this.currentUser = this.token.getUser();
    this.userName = localStorage.getItem('name');

    this.route.queryParams.subscribe(params => {
      this.pattern = params['pattern'];
     // Use the orderId in your component logic
     console.log('Received Pattern:', this.pattern);
     this.searchMovie();


    });


    this.getMovies();
    this.getTopRatedMovies();
  }

  searchMovie(){
    this.movieService.searchMovie(this.pattern).subscribe((data: Movie[]) => {
      this.moviesList = data;
      console.log(this.moviesList[0].movieName)
    })
  }

  getMovies(){
    this.movieService.getMovies().subscribe((data: Movie[]) => {
      this.moviesList = data;
      console.log(this.moviesList)
      console.log(this.moviesList[0].movieId)
    });
  }

  getTopRatedMovies(){
    this.movieService.getTopRatedMovies().subscribe((data: Movie[]) => {
      this.topRatedMoviesList = data;
      console.log(this.topRatedMoviesList)
      console.log(this.topRatedMoviesList[0].movieId)
    });
  }


  getActionMovies(){
    const genre = "Action";
    this.movieService.getMoviesByGenre(genre).subscribe((data: Movie[]) => {
      this.moviesList = data;
      console.log(this.moviesList)
      console.log(this.moviesList[0].movieId)
    });
  }

  getAdventureMovies(){
    const genre = "Adventure";
    this.movieService.getMoviesByGenre(genre).subscribe((data: Movie[]) => {
      this.moviesList = data;
      console.log(this.moviesList)
      console.log(this.moviesList[0].movieId)
    });
  }

  getComedyMovies(){
    const genre = "Comedy";
    this.movieService.getMoviesByGenre(genre).subscribe((data: Movie[]) => {
      this.moviesList = data;
      console.log(this.moviesList)
      console.log(this.moviesList[0].movieId)
    });
  }

  getThrillerMovies(){
    const genre = "Thriller";
    this.movieService.getMoviesByGenre(genre).subscribe((data: Movie[]) => {
      this.moviesList = data;
      console.log(this.moviesList)
      console.log(this.moviesList[0].movieId)
    });
  }


  redirectToPage(movieId: number){
    console.log(movieId);

    this.router.navigate(['/movieInfo'], { queryParams: { movieId: movieId } });


  }

  addToWatchlist(movieId: number){
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
