package com.soni.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soni.model.Movie;

@Controller
@RequestMapping("/movie")
public class MovieController {

	private Map<String, Movie> movies;
	public MovieController(){
		movies = new HashMap<String, Movie>();
		
		Movie movie = new Movie();
		movie.setTitle("Titanic");
		movie.setDirector("James Healy");
		movie.setStarcast("Cate Vinslate");
		movie.setBudget(120000);
		movie.setYear(1980);
		
		movies.put("titanic_1980", movie);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{movieCode}")
	public String showDetails(Model model, @PathVariable String movieCode){
		Movie movie = this.movies.get(movieCode);
		model.addAttribute("movie", movie);
		return "movieDetail.def";
	}
}
