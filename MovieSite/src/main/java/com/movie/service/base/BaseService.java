package com.movie.service.base;

import javax.persistence.MappedSuperclass;

import org.apache.log4j.Logger;

@MappedSuperclass
public abstract class BaseService {

	protected Logger logger;

	public BaseService(Class<?> serviceClass) {
		logger = Logger.getLogger(serviceClass);
	}

}
