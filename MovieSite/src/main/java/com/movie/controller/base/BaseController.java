package com.movie.controller.base;

import org.apache.log4j.Logger;

public abstract class BaseController {

	protected Logger logger;

	public BaseController() {

	}

	public BaseController(Class<?> controllerClass) {
		this.logger = Logger.getLogger(controllerClass);
	}

}
