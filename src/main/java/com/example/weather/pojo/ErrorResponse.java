package com.example.weather.pojo;

import org.springframework.http.HttpStatus;

public class ErrorResponse{


	private int errorCode;
	private String errorMessage;
	private String errorDetail;
	
	public ErrorResponse() {
		
	}
	
	public ErrorResponse(HttpStatus httpStatus, String message, String errorDetail) {
		this();
		this.errorCode = httpStatus.value();
		this.errorMessage = message;
		this.errorDetail = errorDetail;
	}
	
	
	
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}
	
	
}
