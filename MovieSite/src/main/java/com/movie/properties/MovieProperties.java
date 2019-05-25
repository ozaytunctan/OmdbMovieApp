package com.movie.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "movie.prop")
public class MovieProperties {

	/**
	 * OMDB api id value
	 */
	private String omdbId;

	/**
	 * OMDB Api key value
	 */
	private String apiKey;

	/**
	 * OMDB web servis url 
	 */
	private String omdbBaseUrl;

	public String getOmdbId() {
		return omdbId;
	}

	public void setOmdbId(String omdbId) {
		this.omdbId = omdbId;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getOmdbBaseUrl() {
		return omdbBaseUrl;
	}

	public void setOmdbBaseUrl(String omdbBaseUrl) {
		this.omdbBaseUrl = omdbBaseUrl;
	}

}
