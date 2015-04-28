package com.soni.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.soni.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Secured(value="ROLE_DIRECTOR")
	public Map<String, Movie> getAllMovies() {
		Map<String, Movie> movies = new HashMap<String, Movie>();
		// Details of Titanic
		Movie titanic = new Movie();
		titanic.setTitle("Titanic");
		titanic.setDirector("James Healy");
		titanic.setStarcast("Cate Vinslate");
		titanic.setBudget(120000);
		titanic.setYear(1980);
		
		// Details of Internship
		Movie internship = new Movie();
		internship.setTitle("Internship");
		internship.setDirector("Chris Moore");
		internship.setStarcast("Tom Cruize");
		internship.setBudget(21000);
		internship.setYear(1997);
		
		movies.put("titanic_1980", titanic);
		movies.put("internship_1997", internship);
		return movies;
	}
	
	@Secured(value="ROLE_DIRECTOR")
	public Movie getMovieByMovieCode(String movieCode) {
		Map<String, Movie> movies = getAllMovies();
		Movie movie = movies.get(movieCode);
		return movie;
	}
	
}
