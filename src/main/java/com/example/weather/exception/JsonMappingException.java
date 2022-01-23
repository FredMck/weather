package com.example.weather.exception;

public class JsonMappingException extends RuntimeException{
	
	public JsonMappingException (String errorMessage, Throwable err) {
		super(errorMessage,err);
	}
}
