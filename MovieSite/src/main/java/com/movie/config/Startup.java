package com.movie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;

@Component
public class Startup implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public void run(String... args) throws Exception {
		Movie movie = new Movie();
		movie.setId(0);
		movie.setTitle("Batman Snipper");
		this.movieRepository.saveAndFlush(movie);

	}

}
