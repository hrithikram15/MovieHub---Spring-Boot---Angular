import { Component } from '@angular/core';
import { Rating } from './Rating';
import { Movie } from '../all-movies/Movie';
import { MovieServiceService } from '../services/movie-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-show-ratings',
  templateUrl: './show-ratings.component.html',
  styleUrls: ['./show-ratings.component.css']
})
export class ShowRatingsComponent {

  userName: string = "hmk";
  movieId: number = 0;

  avg : number = 0;
  length: number = 0;

  ratings : Rating[] = [];

  movieDetails : Movie = {
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

    


  constructor(private movieService: MovieServiceService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.movieId = params['movieId'];
     // Use the orderId in your component logic
    //  this.userName = localStorage.getItem('name');
    //  console.log(this.userName);
     console.log('Received MovieId:', this.movieId);

  
   });

   this.getMovieDetails(this.movieId);


   this.getReviews(this.movieId);

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


  getReviews(movieId: number){
    this.movieService.getMovieReviews(movieId).subscribe(
      (resp: any) => {
        console.log(resp);
        this.ratings = resp;

        console.log(this.ratings.length);

        this.length = this.ratings.length;
        let sum = 0;


        this.ratings.forEach( x => {
          sum += x.rating;

        })

        console.log(sum)
         this.avg = sum/this.length;

         this.movieDetails.rating = this.avg;

         this.movieService.updateMovie(this.movieDetails, movieId).subscribe(
          (resp: any) => {
            console.log(resp);
            this.movieDetails = resp;
    
            console.log(this.movieDetails.movieName);
          }, (err) => {
            console.log(err);
          }
        )
        //  this.movieService.editRating(avg, movieId)



        console.log(this.avg);

        console.log(this.ratings[0].userName);
      }, (err) => {
        console.log(err);
      }
    )
  }



}
