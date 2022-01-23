package com.example.weather.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeatherDetails implements Serializable{
	

	/*NOTE: Spring uses its own naming strategy which puts underscores in TableName.
	 * So double check this if having issues.
	 * Also if you use Auto, Spring will create a hibernate_sequence table to track the ID
	 * TLDR: create a table with underscores and use GenerationType.IDENTITY straight away */
	
	/*Builder Pattern to help deal with lots of fields*/
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String date;

	/*Location*/
	private String name;
	private String region;
	private String country;
	private int lat;
	private int lon;
	
	/*Current*/
	private String last_updated;
	private int temp_c;
	private int temp_f;
	
	private WeatherDetails(String date, String name, String region, String country, int lat, int lon, String last_updated, int temp_c, int temp_f) {
		this.date = date;
		this.name = name;
		this.region = region;
		this.country = country;
		this.lat = lat;
		this.lon = lon;
		this.last_updated = last_updated;
		this.temp_c = temp_c;
		this.temp_f = temp_f;
		
		
	}
	
	private WeatherDetails() {
		
	}

	public int getId() {
		return id;
	}
/*	public void setId(int id) {
		this.id = id;
	}*/
	public String getDate() {
		return date;
	}
/*	public void setDate(String date) {
		this.date = date;
	}*/
	public String getName() {
		return name;
	}
/*	public void setName(String name) {
		this.name = name;
	}*/
	public String getRegion() {
		return region;
	}
/*	public void setRegion(String region) {
		this.region = region;
	}*/
	public String getCountry() {
		return country;
	}
/*	public void setCountry(String country) {
		this.country = country;
	}*/
	public int getLat() {
		return lat;
	}
/*	public void setLat(int lat) {
		this.lat = lat;
	}*/
	public int getLon() {
		return lon;
	}
/*	public void setLon(int lon) {
		this.lon = lon;
	}*/
	public String getLast_updated() {
		return last_updated;
	}
/*	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}*/
	public int getTemp_c() {
		return temp_c;
	}
/*	public void setTemp_c(int temp_c) {
		this.temp_c = temp_c;
	}*/
	public int getTemp_f() {
		return temp_f;
	}
/*	public void setTemp_f(int temp_f) {
		this.temp_f = temp_f;
	}*/
	
	
	public static WeatherDetailsBuilder builder () {
		return new WeatherDetailsBuilder();
	}
	
	
	
	public static class WeatherDetailsBuilder {
		
		private String date;

		/*Location*/
		private String name;
		private String region;
		private String country;
		private int lat;
		private int lon;
		
		/*Current*/
		private String last_updated;
		private int temp_c;
		private int temp_f;
		
		
		public WeatherDetailsBuilder withDate(String date) {
			this.date = date;
			return this;
		}
		public WeatherDetailsBuilder withName(String name) {
			this.name = name;
			return this;
		}
		public WeatherDetailsBuilder withRegion(String region) {
			this.region = region;
			return this;
		}
		public WeatherDetailsBuilder withCountry(String country) {
			this.country = country;
			return this;
		}
		public WeatherDetailsBuilder withLat(int lat) {
			this.lat = lat;
			return this;
		}
		public WeatherDetailsBuilder withLon(int lon) {
			this.lon = lon;
			return this;
		}
		public WeatherDetailsBuilder withLastUpdated(String last_updated) {
			this.last_updated = last_updated;
			return this;
		}
		public WeatherDetailsBuilder withTempC(int temp_c) {
			this.temp_c = temp_c;
			return this;
		}
		public WeatherDetailsBuilder withTempF(int temp_f) {
			this.temp_f = temp_f;
			return this;
		}
		
		public WeatherDetails build () {
			return new WeatherDetails(date, name, region, country, lat, lon, last_updated, temp_c, temp_f);
		}
		
	}
	
}

