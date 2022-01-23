package com.example.weather.logging;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.weather.pojo.WeatherResponse;

@Component
public class ApiLogging {

	static Logger logger = Logger.getLogger(ApiLogging.class);
	
	
	
	
	public void initialRequest(HttpServletRequest request) {
		
		StringBuilder reqUri = new StringBuilder(request.getRequestURL().toString());
		String queryString = request.getQueryString();
		logger.info("-----------INITIAL REQUEST-----------");
		//logger.info("HEADERS: " + request.getHeaderNames());
		logger.info("URL: " + reqUri.append('?').append(queryString).toString());
	}
	
	public void outboundRequest(String sentUrl) {
		logger.info("-----------OUTBOUND REQUEST-----------");
		logger.info("SENT URL: " + sentUrl);
		
	}
	
	public void incomingResponse(WeatherResponse body) {
		logger.info("-----------INCOMING RESPONSE-----------");
		logger.info("Response JSON:\n" );
		
	}
	
	public void outgoingResponse() {
		logger.info("-----------OUTGOING RESPONSE-----------");
		
	}
}
