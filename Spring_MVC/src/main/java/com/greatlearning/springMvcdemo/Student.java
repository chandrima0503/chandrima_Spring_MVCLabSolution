package com.greatlearning.springMvcdemo;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;

	private String country;

	private LinkedHashMap<String, String> countries;

	private String favoriteLanguage;

	private String[] operatingSystems;

	public Student() {

		// populate countries
		countries = new LinkedHashMap<>();

		
		countries.put("AUS", "Australia");
		countries.put("CAN", "Canada");
		countries.put("IN", "India");
		countries.put("NP", "Nepal");
		countries.put("RUS", "Russia");
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountries() {
		return countries;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

}
