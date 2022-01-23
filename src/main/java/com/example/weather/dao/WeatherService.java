package com.example.weather.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.weather.entity.WeatherDetails;
import com.example.weather.pojo.WeatherResponse;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherDao weatherDao;

	
	@Transactional
	public void insertIntoWeatherDetails (ResponseEntity<WeatherResponse> response) {
		System.out.println("INSIDE WEATHER SERVICE");
		weatherDao.persistWeatherData(response);
	}

}
