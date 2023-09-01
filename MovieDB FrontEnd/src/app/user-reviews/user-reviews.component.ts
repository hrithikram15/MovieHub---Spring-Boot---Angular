import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { MovieServiceService } from '../services/movie-service.service';
import { TokenStorageService } from '../services/token-storage.service';
import { Rating } from '../show-ratings/Rating';
import { Movie } from '../all-movies/Movie';


@Component({
  selector: 'app-user-reviews',
  templateUrl: './user-reviews.component.html',
  styleUrls: ['./user-reviews.component.css']
})
export class UserReviewsComponent {

  userName : any = "";

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


  constructor(private http:HttpClient, private movieService: MovieServiceService, private router : Router, private token: TokenStorageService, private route: ActivatedRoute ) { }

  ngOnInit(): void {
    this.userName = localStorage.getItem('name');

    this.getUserReviews()
  }

  getUserReviews(){
    this.movieService.getUserReviews(this.userName).subscribe(
      (resp: any) => {
        console.log(resp);
        this.ratings = resp;

        console.log(this.ratings.length);
      }, (err) => {
        console.log(err);
      }
    )
  }

  deleteRating(ratingId: number){
    this.movieService.deleteRating(ratingId).subscribe(
      (resp: any) => {
        console.log(resp);
        this.getUserReviews();

      }, (err) => {
        console.log(err);
      }
    )
  }



}
