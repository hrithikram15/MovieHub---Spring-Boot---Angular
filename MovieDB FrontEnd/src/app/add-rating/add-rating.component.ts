import { Component } from '@angular/core';
import { MovieServiceService } from '../services/movie-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Movie } from '../all-movies/Movie';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-add-rating',
  templateUrl: './add-rating.component.html',
  styleUrls: ['./add-rating.component.css']
})
export class AddRatingComponent {

  errMsg: String = "";

  userName: any = "hmk";
  movieId : number = 0;

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
  currentUser: any;

  constructor(private movieService: MovieServiceService, private router: Router, private route: ActivatedRoute, private token: TokenStorageService) { }

  ngOnInit(): void {

    this.currentUser = this.token.getUser();
    this.userName = localStorage.getItem('name');
    console.log(this.userName)

    this.route.queryParams.subscribe(params => {
      this.movieId = params['movieId'];
     // Use the orderId in your component logic
    //  this.userName = localStorage.getItem('name');
    //  console.log(this.userName);
     console.log('Received movieId:', this.movieId);

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

  addReview(registerForm: NgForm){

    registerForm.value.ratingId = 7;


    console.log(registerForm.value)
    this.movieService.addReview(registerForm.value, this.userName, this.movieId).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(['/showRatings'], { queryParams: { movieId: this.movieId } });
      },
      (error) => {
        console.log(error);

        if(error){
          this.errMsg = "User Review Already Exists For This Movie!!!";
        }

      }
      );  

  }

}
