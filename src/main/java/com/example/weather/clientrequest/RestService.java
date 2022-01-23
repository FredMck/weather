/*package com.example.weather.clientrequest;

import org.springframework.http.HttpStatus;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.weather.pojo.WeatherResponse;

@Service
public class RestService {
	
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    
    
	
	public WeatherResponse getWeatherApi()	{
		String url = "https://api.weatherapi.com/v1/current.json?key=c9680cd898204303b85131001200411&q=Thatcham";
		ResponseEntity<WeatherResponse> response = this.restTemplate.getForEntity(url, WeatherResponse.class, 1);
		
		if(response.getStatusCode() == HttpStatus.OK) {
			WeatherResponse resp = response.getBody();
			System.out.println("Country: " + resp.getLocation().getCountry());
			
	        return resp;
	    } else {
	    	System.out.println("In ELSE");
	        return null;
	    }
		
	
	}
}
*/