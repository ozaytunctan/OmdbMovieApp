package com.movie;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.movie.properties.MovieProperties;

/**
 * Main Application Started.
 * 
 * @author otunctan
 *
 */
@SpringBootApplication
@EntityScan(basePackages = "com.movie.model")
@EnableJpaRepositories(basePackages = "com.movie.repository")
@EnableConfigurationProperties(value = { MovieProperties.class })
public class MovieSiteApplication {

	private static Logger logger;

	static {
		logger = Logger.getLogger(MovieSiteApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(MovieSiteApplication.class, args);

		logger.info(">>>MOVIE SITE APPLICATION STARTED...>>>");
	}

}
