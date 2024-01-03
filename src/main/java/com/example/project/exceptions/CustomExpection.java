package com.example.project.exceptions;

import org.springframework.http.HttpStatus;

public class CustomExpection {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpstatus;
	
	public CustomExpection(String message, Throwable throwable, HttpStatus httpstatus) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpstatus = httpstatus;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the throwable
	 */
	public Throwable getThrowable() {
		return throwable;
	}

	/**
	 * @return the httpstatus
	 */
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	
	
	

}
