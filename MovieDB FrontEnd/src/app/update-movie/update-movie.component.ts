import { Component, OnInit } from '@angular/core';
import { Movie } from '../all-movies/Movie';
import { MovieServiceService } from '../services/movie-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-movie',
  templateUrl: './update-movie.component.html',
  styleUrls: ['./update-movie.component.css']
})
export class UpdateMovieComponent implements OnInit{

  movieId: number = 0;

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

  


  constructor(private movieService: MovieServiceService, private router: Router, private route : ActivatedRoute) { }

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.movieId = params['movieId'];
     // Use the orderId in your component logic
     console.log('Received movieId:', this.movieId);
   });

   this.getMovieDetails(this.movieId);
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

  updateMovie(registerForm: NgForm){

    // registerForm.value.productId = 7;


    console.log(registerForm.value)
    this.movieService.updateMovie(registerForm.value, this.movieId).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(['/showMovies']);
      },
      (error) => {
        console.log(error);
      }
      );  

  }

}
