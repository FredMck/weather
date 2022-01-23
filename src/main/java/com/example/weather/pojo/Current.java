package com.example.weather.pojo;

//import com.fasterxml.jackson.annotation.JsonProperty;

public class Current {
	
	/*NOTE: If you want to use camel case then use JsonPropery annotation to map to incoming JSON value*/
	/*@JsonProperty(value="last_updated")
	private String lastUpdated;*/
	
	private String last_updated;
	private int temp_c;
	private int temp_f;
	
	public String getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(String lastUpdated) {
		this.last_updated = lastUpdated;
	}
	public int getTemp_c() {
		return temp_c;
	}
	public void setTemp_c(int temp_c) {
		this.temp_c = temp_c;
	}
	public int getTemp_f() {
		return temp_f;
	}
	public void setTemp_f(int temp_f) {
		this.temp_f = temp_f;
	}
	
	
}
