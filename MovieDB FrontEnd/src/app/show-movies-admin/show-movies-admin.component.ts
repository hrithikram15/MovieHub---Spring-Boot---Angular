import { Component } from '@angular/core';
import { MovieServiceService } from '../services/movie-service.service';
import { Router } from '@angular/router';
import { Movie } from '../all-movies/Movie';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-show-movies-admin',
  templateUrl: './show-movies-admin.component.html',
  styleUrls: ['./show-movies-admin.component.css']
})
export class ShowMoviesAdminComponent {

  displayedColumns: string[] = ['Id', 'movieName', 'director', 'production', 'cast' ,'Actions'];
  movieDetails: Movie[] = [];

  constructor(private movieService: MovieServiceService, private router: Router) { }

  ngOnInit(): void {
    this.getAllMovies();

  }
  getAllMovies(){
    this.movieService.getMovies().subscribe(data => {
      this.movieDetails = data;
      console.log(this.movieDetails)
      console.log(this.movieDetails[0].movieName)
    });
  }

  deleteMovie(movieId: number){
    this.movieService.deleteMovie(movieId).subscribe(
      (resp)=> {
        this.getAllMovies();
      },
      (error: HttpErrorResponse) => {
        console.log(error);}
    );    
  }

  editMovieDetails(movieId: number){
    this.router.navigate(['/updateMovie'], { queryParams: { movieId: movieId } })
  }


}
