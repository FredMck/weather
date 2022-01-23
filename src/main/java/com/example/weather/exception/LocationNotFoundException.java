package com.example.weather.exception;

import org.springframework.http.ResponseEntity;

import com.example.weather.pojo.ErrorResponse;

public class LocationNotFoundException extends RuntimeException{

	
	public LocationNotFoundException() {
		super();
	}
	
	public LocationNotFoundException(String message) {
		super(message);
	}
	

}
