package com.movie.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Base entity sınıfıdır. Bu sınıf modeller de ortak kullanılacak alanları
 * içerir.
 * 
 * @author otunctan
 *
 * @param <ID>
 *            entity id
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseEntity<ID extends Number> implements Serializable {

	@Id
	@GeneratedValue(generator = "idGenerator", strategy = GenerationType.SEQUENCE)
	private ID id;

	@Column(name = "CreatedDate")
	@Temporal(TemporalType.DATE)
	private Date createdDate=new Date();

	public BaseEntity() {
	
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
