package com.example.mohituniyal.watchlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class movieRating {

	
	String apiurl = "https://www.omdbapi.com/?apikey=cb2125ab&t="; 
	
	
	public String getMovieRating(String title) {
	try {
		// Trying to fetch the api rating by calling ombd api;
		RestTemplate template = new RestTemplate();
		//apiUrl + title 
		ResponseEntity<ObjectNode> response = template.getForEntity(apiurl +title,  ObjectNode.class);
		// Taking json from ResponseEntity
		ObjectNode jsonObject = response.getBody();
		
	
		return jsonObject.path("imdbRating").asText();
	}catch(Exception e) {
		System.out.println("Either movie name is not available or api is down" + e.getMessage());
		return null;
	}
}
}
