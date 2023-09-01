import { Component } from '@angular/core';
import { MovieServiceService } from '../services/movie-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from '../all-movies/Movie';

@Component({
  selector: 'app-movie-info',
  templateUrl: './movie-info.component.html',
  styleUrls: ['./movie-info.component.css']
})
export class MovieInfoComponent {

  movieId : number = 0;

  userName: any = "hmk";

  errMsg: String = "";

  movieDetails: Movie = {
    movieId: 0,
    movieName: '',
    yor: '',
    cast: '',
    director: '',
    production: '',
    genre: '',
    budget: '',
    boCollection: '',
    plot: '',
    imageURL: '',
    rating: 0,
    language: ''
  }


  constructor(private movieService : MovieServiceService, private router : Router, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.userName = localStorage.getItem('name');
    console.log(this.userName)

    this.route.queryParams.subscribe(params => {
      this.movieId = params['movieId'];
     // Use the orderId in your component logic
     console.log('Received movieId:', this.movieId);

    //  this.getProductDetails(this.productId);

    this.getMovieDetails(this.movieId);
   });
  }

  

  getMovieDetails(movieId: number){
    this.movieService.getMovieById(movieId).subscribe(
      (resp: any) => {
        console.log(resp);
        this.movieDetails = resp;

        console.log(this.movieDetails.movieName);
      }, (err) => {
        console.log(err);
      }
    )
  }

  addToWatchlist(movieId: number){
    console.log(movieId);

    this.movieService.addMovieToWatchlist(movieId, this.userName).subscribe(
      (data)=>{
      console.log(data);

      this.router.navigate(['/watchlist']);


    },
  (error) => {
    console.log(error);
  })

  }

  addReview(movieId: number){

    this.movieService.checkUserReview(this.userName, movieId).subscribe(
      (data)=>{
      console.log(data);
      if(data===true){
        this.errMsg = "User review already exists for this movie!!!"
      }else{
        this.router.navigate(['/addRating'], { queryParams: { movieId: movieId } });

      }

    },
  (error) => {
    console.log(error);
  })


  }

  showAllReviews(movieId: number){


    this.router.navigate(['/showRatings'], { queryParams: { movieId: movieId } });


  }

}
