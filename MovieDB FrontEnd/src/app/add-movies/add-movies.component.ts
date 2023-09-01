import { Component } from '@angular/core';
import { MovieServiceService } from '../services/movie-service.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-add-movies',
  templateUrl: './add-movies.component.html',
  styleUrls: ['./add-movies.component.css']
})
export class AddMoviesComponent {

  constructor(private movieService: MovieServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  
  addMovie(registerForm: NgForm){

    registerForm.value.movieId = 700;


    console.log(registerForm.value)
    this.movieService.addNewMovie(registerForm.value).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(['/allMovies']);
      },
      (error) => {
        console.log(error);
      }
      );  

  }


}
