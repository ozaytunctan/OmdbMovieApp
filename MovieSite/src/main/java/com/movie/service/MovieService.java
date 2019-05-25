package com.movie.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.dto.OmdbMovieDto;
import com.movie.helper.OmdbWebServiceClient;
import com.movie.model.Movie;
import com.movie.properties.MovieProperties;
import com.movie.repository.MovieRepository;
import com.movie.service.base.BaseService;

/**
 * MovieService.java Film servis sınıfıdır.Film business işlemleri bu sınıf
 * üzerinden sağlanmaktadır.
 * 
 * @author otunctan
 *
 */
@Service
public class MovieService extends BaseService {

	// @Autowired ile inject edilebilir.
	private MovieRepository movieRepository;

	private RestTemplate restTemplate;

	private MovieProperties movieProperties;

	private ObjectMapper objectMapper;

	private OmdbWebServiceClient omdbWebServiceClient;

	// Constructor Injection
	public MovieService(MovieRepository movieRepository, RestTemplate restTemplate, ObjectMapper objectMapper,
			OmdbWebServiceClient omdbWebServiceClient, MovieProperties movieProperties) {
		super(MovieService.class);
		this.movieRepository = movieRepository;
		this.restTemplate = restTemplate;
		this.movieProperties = movieProperties;
		this.objectMapper = objectMapper;
		this.omdbWebServiceClient = omdbWebServiceClient;

	}

	public List<Movie> findMoviesByTitle(String title) {
		logger.info("MovieService.java-->findMoviesByTitle metod call title parameter=" + title);

		List<Movie> filterMovieList = this.movieRepository.findMoviesByTitle(title);

		if (Objects.nonNull(filterMovieList) && filterMovieList.isEmpty()) {

			List<Movie> movies = mapToMovie(getMoviesOmdbByTitle(title));

			insertMovie(movies);
		}

		return filterMovieList;
	}

	private void insertMovie(List<Movie> movies) {
		Optional.ofNullable(movies).ifPresent(movie -> {
			this.movieRepository.saveAll(movie);
		});

	}

	private List<Movie> mapToMovie(OmdbMovieDto moviesOmdbByTitle) {

		if (Objects.nonNull(moviesOmdbByTitle) && Boolean.parseBoolean(moviesOmdbByTitle.getResponse()))
			return mapTo(moviesOmdbByTitle.getSearch(), Movie.class);

		return Arrays.asList();
	}

	/**
	 * Örnek request t:http://www.omdbapi.com/?i=tt3896198&apikey=563ad9aa&t=Batman
	 * s:http://www.omdbapi.com/?i=tt3896198&apikey=563ad9aa&s=Batman
	 * 
	 * @param title
	 * @return
	 */
	private OmdbMovieDto getMoviesOmdbByTitle(String title) {

		OmdbMovieDto movies = new OmdbMovieDto();

		if (Objects.nonNull(title)) {
			String json = omdbWebServiceClient.sendGetRequest(title);
			try {
				movies = this.objectMapper.readValue(json, OmdbMovieDto.class);
			} catch (IOException e) {
				logger.info("MovieService.java-->getMoviesOmdbByTitle metod call error=" + title);
			}
		}
		return movies;

	}

}
