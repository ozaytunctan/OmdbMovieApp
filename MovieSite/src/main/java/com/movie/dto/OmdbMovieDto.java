package com.movie.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie.model.Movie;

public class OmdbMovieDto {

	@JsonProperty("Search")
	private List<MovieDto> search;
	@JsonProperty("totalResults")
	private String totalResults;
	@JsonProperty("Response")
	private String response;

	public OmdbMovieDto() {
		// TODO Auto-generated constructor stub
	}

	public List<MovieDto> getSearch() {
		return search;
	}

	public void setSearch(List<MovieDto> search) {
		this.search = search;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
