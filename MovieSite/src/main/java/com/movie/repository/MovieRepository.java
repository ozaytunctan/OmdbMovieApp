package com.movie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movie.model.Movie;

/**
 * MovieRepository.java Film crud işlemlerinin yapılacağı repository interface
 * dir.
 * 
 * @author otunctan
 *
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

	/**
	 * DSL Query film başlığı parametresine göre filmleri veritabanından listeleyen
	 * metod.
	 * 
	 * @param title
	 * @return Optional<List<Movie>>
	 */
	Optional<List<Movie>> findMovieByTitle(String title);
	
	/**
	 * 
	 * @param title
	 * @return
	 */
	@Query(value="select mv from Movie mv where mv.title like %:movieTitle% ")
	public List<Movie>findMoviesByTitle(@Param("movieTitle")String title);

}
