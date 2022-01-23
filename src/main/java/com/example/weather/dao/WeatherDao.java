package com.example.weather.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.weather.entity.WeatherDetails;
import com.example.weather.pojo.WeatherResponse;

@Repository
public class WeatherDao {
	
	@PersistenceContext()
	private EntityManager entityManager;
    
    
    public void persistWeatherData (ResponseEntity<WeatherResponse> response) {
    	
    	System.out.println("INSIDE PERSISTENCE DAO");
    	System.out.println("Region: " + response.getBody().getLocation().getRegion());
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();
    	
	    WeatherDetails weatherDetails = null;
    	if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("Enters OK: ");
			
		    
		    
	    	weatherDetails = WeatherDetails.builder().withDate(dtf.format(now).toString())
					.withName(response.getBody().getLocation().getName())
					.withRegion(response.getBody().getLocation().getRegion())
					.withCountry(response.getBody().getLocation().getCountry())
					.withLat(response.getBody().getLocation().getLat())
					.withLon(response.getBody().getLocation().getLon())
					.withLastUpdated(response.getBody().getCurrent().getLast_updated())
					.withTempC(response.getBody().getCurrent().getTemp_c())
					.withTempF(response.getBody().getCurrent().getTemp_f())
					.build();
		
		} else {
	    	weatherDetails = WeatherDetails.builder().withDate(dtf.format(now).toString())
					.withLon(response.getBody().getError().getCode())
					.withName(response.getBody().getError().getMessage())
					.build();	
		}
    	

    	

    															
    	entityManager.persist(weatherDetails);
    	
    	
    }

}
