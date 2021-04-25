package com.xebia.table_tennis.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
	
	private HttpStatus httpStatus;
	
	public ApiException(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public ApiException(String message, Throwable cause, HttpStatus httpStatus) {
		super(message, cause);
		this.httpStatus = httpStatus;
	}

}
