package com.soni.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.soni.model.Movie;

@Repository
@Transactional(propagation=Propagation.REQUIRED, timeout=300)
public class MovieServiceImpl implements MovieService {
	
	@PreAuthorize("hasRole('ROLE_DIRECTOR')")
	public Map<String, Movie> getAllMovies() {
		Map<String, Movie> movies = new HashMap<String, Movie>();
		// Details of Titanic
		Movie titanic = new Movie();
		titanic.setTitle("Titanic");
		titanic.setDirector("James Healy");
		titanic.setStarcast("Cate Vinslate");
		titanic.setBudget(20000);
		titanic.setYear(1980);
		
		// Details of Internship
		Movie internship = new Movie();
		internship.setTitle("Internship");
		internship.setDirector("Chris Moore");
		internship.setStarcast("Tom Cruize");
		internship.setBudget(70000);
		internship.setYear(1997);
		
		movies.put("titanic_1980", titanic);
		movies.put("internship_1997", internship);
		return movies;
	}
	
	@PreAuthorize("#movieCode.length() > 4 and hasRole('ROLE_DIRECTOR')")
	@PostAuthorize("T(java.lang.Integer).parseInt(getReturnObject().budget) < 50000 and getThis().getDirectorName().equals('RamGopal')")
	public Movie getMovieByMovieCode(String movieCode) {
		Map<String, Movie> movies = getAllMovies();	// DIRECT CALL
		//MovieService movieService = (MovieService)AopContext.currentProxy();	// GETTING CURRENT PROXY OBJECT/REFERENCE.
		//Map<String, Movie> movies = movieService.getAllMovies();	// CALL ON PROXY OBJECT.
		Movie movie = movies.get(movieCode);
		return movie;
	}
	
	public String getDirectorName(){
		return "RamGopal";
	}
	
	@PostFilter("filterObject.length()>3")
	public List<String> addNewMovies(List<String> newMovies){
		List<String> allMovieTitles = new ArrayList<String>();
		allMovieTitles.addAll(newMovies);
		Map<String, Movie> allMovies = getAllMovies();
		for(Movie movie : allMovies.values()){
			allMovieTitles.add(movie.getTitle());
		}
		return allMovieTitles;
	}
}
