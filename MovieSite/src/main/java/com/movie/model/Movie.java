package com.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Movie.class Film bilgilerinin tutulduğu entity sınıfıdır.
 * 
 * @author otunctan
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Movie")
@SequenceGenerator( name = "idGenerator", initialValue = 1, allocationSize = 1,sequenceName = "SQ_Movie")
public class Movie extends BaseEntity<Integer> {

	
	@Column(name="Title")
	private String title;
	
	
	public Movie() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
