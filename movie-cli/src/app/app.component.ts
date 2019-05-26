import { FormControl } from '@angular/forms';
import { Component } from '@angular/core';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { FilmService } from './service/film-service';
import { Movie } from './model/movie.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  title = 'movie-cli';
  filmCtrl = new FormControl();
  filteredFilms: Observable<Movie[]>;
  films;

  constructor(private filmService:FilmService) {
 
    this.filteredFilms = this.filmCtrl.valueChanges
      .pipe(
        startWith(''),
        map(film => film ? this._filterFilm(film) : this.films.slice())
      );
  }

  private _filterFilm(value: string) {
    const filterValue = value.toLowerCase();
    return this.filmService.getSearchMovieByTitle(value)
    .then(data=>data.filter(film => film.title.toLowerCase()
    .indexOf(filterValue) === 0));
  
  }

}