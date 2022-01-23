package com.example.weather.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.example.weather.dao.WeatherService;
import com.example.weather.exception.JsonMappingException;
import com.example.weather.exception.LocationNotFoundException;
import com.example.weather.logging.ApiLogging;
import com.example.weather.pojo.ErrorResponse;
import com.example.weather.pojo.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private ApiLogging apiLogging;
	
	/*URL: http://localhost:8080/weather/location?location=xyz*/
	@GetMapping("/location")
	public ResponseEntity<WeatherResponse> setLocation(@RequestParam String location, HttpServletRequest request) {
		System.out.println("Location Provided: " + location + "\n");
		apiLogging.initialRequest(request);
		
		ResponseEntity<WeatherResponse> resp = requestToWeatherAPI(location);
		
		weatherService.insertIntoWeatherDetails(resp);
		return resp;
	}
	
	
	
	private ResponseEntity<WeatherResponse> requestToWeatherAPI(String location) {
		 RestTemplate restTemplate = new RestTemplate();
		 String url = "https://api.weatherapi.com/v1/current.json?key=c9680cd898204303b85131001200411&q=" + location;
		 apiLogging.outboundRequest(url);
		 
		 ResponseEntity<WeatherResponse> response = null;
		 try {
			 response = restTemplate.getForEntity(url, WeatherResponse.class);
		 } catch (BadRequest ex) {
			 /*TODO: Currently the errorMessage from weather company is already in JSON format, so Spring serialises it again causing backslashes.*/
			 throw new LocationNotFoundException(ex.getMessage());
		 }
		 
		return response;
	}
	
	
	
	
	private WeatherResponse deserializeMapper(String requestBody) {
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse weatherResp;
		try {
			weatherResp = mapper.readValue(requestBody, WeatherResponse.class);
		} catch (JsonProcessingException e) {
			throw new JsonMappingException("Failed to map incoming JSON", e);
		}
		
		return weatherResp;
	}
	
	private ErrorResponse deserializeMapperError(String requestBody) {
		ObjectMapper mapper = new ObjectMapper();
		ErrorResponse weatherResp;
		try {
			weatherResp = mapper.readValue(requestBody, ErrorResponse.class);
		} catch (JsonProcessingException e) {
			throw new JsonMappingException("Failed to map incoming JSON", e);
		}
		
		return weatherResp;
	}

}
