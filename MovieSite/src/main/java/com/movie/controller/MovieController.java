package com.movie.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.controller.base.BaseController;
import com.movie.model.Movie;
import com.movie.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController extends BaseController {

	@Autowired
	private MovieService movieService;

	public MovieController() {
		super(MovieController.class);
	}

	@GetMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movie>> findMoviesByTitle(@Valid @RequestParam("title") String title) {
		logger.info("MovieController.class-->findMoviesByTitle() metod call title param:" + title);
		return ResponseEntity.status(HttpStatus.OK).body(movieService.findMoviesByTitle(title));
	}

	/**
	 * Film başlığına göre veritabanından paging yaparak filmlerinin listesini
	 * return eden rest controller metodudur.
	 * 
	 * @param title
	 *            Aranacak film başlığı
	 * @param pf
	 *            başlangıc index numarası
	 * @param pl
	 *            bitiş index numarası
	 * @return List<Movie> film listesi
	 */
	@GetMapping(path = "/search-page", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movie>> findMoviesByTitle(@Valid @RequestParam("title") String title,
			@RequestParam(name = "pf", defaultValue = "0") Integer firstIndex,
			@RequestParam(name = "pl", defaultValue = "1000") Integer lastIndex) {
	
		logger.info("MovieController.class-->findMoviesByTitle() metod call title param:" + title);

		return ResponseEntity.status(HttpStatus.OK).body(movieService.findMoviesByTitle(title));
	}
}
