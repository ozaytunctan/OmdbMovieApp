
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from '../model/movie.model';


@Injectable({
    providedIn: "root"
})
export class FilmService {

    private customersUrl = 'movie/search?title=';  // URL to web API
 
    constructor(private http: HttpClient) { }
   
    // Get all films
    getSearchMovieByTitle(title:string): Promise<Movie[]> {
      return this.http.get(this.customersUrl.concat(title))
                 .toPromise()
                 .then(response => response as Movie[])
                 .catch(this.handleError);
    }
   
    private handleError(error: any): Promise<any> {
      console.error('Error', error);
      return Promise.reject(error.message || error);
    }

    public searchFilmsByTitle(title:string){
        return null;
    }


}