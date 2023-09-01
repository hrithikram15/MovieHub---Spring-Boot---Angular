import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllMoviesComponent } from './all-movies/all-movies.component';
import { WatchlistComponent } from './watchlist/watchlist.component';
import { AddRatingComponent } from './add-rating/add-rating.component';
import { AddMoviesComponent } from './add-movies/add-movies.component';
import { ShowMoviesAdminComponent } from './show-movies-admin/show-movies-admin.component';
import { ShowRatingsComponent } from './show-ratings/show-ratings.component';
import { UpdateMovieComponent } from './update-movie/update-movie.component';
import { MovieInfoComponent } from './movie-info/movie-info.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { TopRatedComponent } from './top-rated/top-rated.component';
import { UserReviewsComponent } from './user-reviews/user-reviews.component';


const routes: Routes = [

  { path: '', component: AllMoviesComponent }, //both
  { path: 'watchlist', component: WatchlistComponent }, //both
  { path: 'addRating', component: AddRatingComponent }, 
  { path: 'addMovie', component: AddMoviesComponent }, 
  { path: 'allMovies', component: AllMoviesComponent }, 
  { path: 'login', component: LoginComponent }, 
  { path: 'register', component: RegisterComponent }, 
  { path: 'topRatedMovies', component: TopRatedComponent }, 

  { path: 'showRatings', component: ShowRatingsComponent }, 
  { path: 'myReviews', component: UserReviewsComponent }, 

  { path: 'showMovies', component: ShowMoviesAdminComponent }, 
  { path: 'updateMovie', component: UpdateMovieComponent }, 
  {path: 'movieInfo', component: MovieInfoComponent}, //both


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
