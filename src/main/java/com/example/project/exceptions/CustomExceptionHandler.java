package com.example.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(value= {CustomExceptionMessage.class})
	public ResponseEntity<Object> handleexception(CustomExceptionMessage exception)
	{
		CustomExpection l=new CustomExpection(exception.getMessage(),exception.getCause(),HttpStatus.BAD_REQUEST);
				return new ResponseEntity<>(l,HttpStatus.BAD_REQUEST);
	}
	

}
