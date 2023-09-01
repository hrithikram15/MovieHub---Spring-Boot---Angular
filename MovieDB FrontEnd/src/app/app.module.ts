import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import {MatDialogModule} from '@angular/material/dialog';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AllMoviesComponent } from './all-movies/all-movies.component';
import { HeaderComponent } from './header/header.component';
import { WatchlistComponent } from './watchlist/watchlist.component';
import { AddRatingComponent } from './add-rating/add-rating.component';
import { AddMoviesComponent } from './add-movies/add-movies.component';
import { ShowRatingsComponent } from './show-ratings/show-ratings.component';
import { ShowMoviesAdminComponent } from './show-movies-admin/show-movies-admin.component';
import { UpdateMovieComponent } from './update-movie/update-movie.component';
import { MovieInfoComponent } from './movie-info/movie-info.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { TopRatedComponent } from './top-rated/top-rated.component';
import { UserReviewsComponent } from './user-reviews/user-reviews.component';

@NgModule({
  declarations: [
    AppComponent,
    AllMoviesComponent,
    HeaderComponent,
    WatchlistComponent,
    AddRatingComponent,
    AddMoviesComponent,
    ShowRatingsComponent,
    ShowMoviesAdminComponent,
    UpdateMovieComponent,
    MovieInfoComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    TopRatedComponent,
    UserReviewsComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatGridListModule,
    MatTableModule,
    MatIconModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
