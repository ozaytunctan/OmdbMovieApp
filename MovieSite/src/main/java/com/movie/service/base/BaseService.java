package com.movie.service.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.MappedSuperclass;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@MappedSuperclass
public abstract class BaseService {

	protected Logger logger;

	@Autowired
	protected ModelMapper modelMapper;

	public BaseService(Class<?> serviceClass) {
		logger = Logger.getLogger(serviceClass);
	}

	public <S, T> List<T> mapTo(List<S> source, Class<T> targetClass) {
		List<T> list = new ArrayList<>();
		for (S s : source) {
			list.add(mapTo(s, targetClass));
		}
		return list;
	}

	public <S, T> T mapTo(S source, Class<T> targetClass) {
		return this.modelMapper.map(source, targetClass);
	}

}
