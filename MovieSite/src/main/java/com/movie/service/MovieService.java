package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;
import com.movie.service.base.BaseService;

/**
 * MovieService.java Film servis sınıfıdır.
 * 
 * @author otunctan
 *
 */
@Service
public class MovieService extends BaseService {

	// @Autowired ile inject edilebilir.
	private MovieRepository movieRepository;

	// Constructor Injection
	public MovieService(MovieRepository movieRepository) {
		super(MovieService.class);
		this.movieRepository=movieRepository;

	}

	public List<Movie> findMoviesByTitle(String title) {
	 logger.info("MovieService.java-->findMoviesByTitle metod call title parameter=" + title);
	 List<Movie> filterMovieList = this.movieRepository.findMoviesByTitle(title);
	
	 return filterMovieList;
	 }

}
