package com.example.weather.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.weather.exception.LocationNotFoundException;
import com.example.weather.pojo.ErrorResponse;

@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler{


	
	  @ExceptionHandler(LocationNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleLocationNotFound(LocationNotFoundException ex, WebRequest request) {
		  HttpStatus status = HttpStatus.NOT_FOUND;

		  ErrorResponse errResp = new ErrorResponse();
		  errResp.setErrorCode(status.value());
		  errResp.setErrorMessage(ex.getMessage());
		  errResp.setErrorDetail(request.getDescription(true));
		  
		  
		  return new ResponseEntity<>(errResp, status);
	  }
	  

	  
	  
	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorResponse> handleCatchAll(Exception ex, WebRequest request) {
		  HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		  
		  ErrorResponse errResp = new ErrorResponse();
		  errResp.setErrorCode(status.value());
		  errResp.setErrorMessage(ex.getMessage());
		  errResp.setErrorDetail(request.getDescription(true));
		  
		  return new ResponseEntity<>(errResp, status);
	  }
	  
}
