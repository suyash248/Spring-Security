package com.soni.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	}
	@RequestMapping(method=RequestMethod.GET, value="/movieDetailsForm")
	public String movieDetailsForm() {
		return "movieDetailsForm.def";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/showMovieDetails")
	public String showDetails(Model model, HttpServletRequest request){
		String movieCode = request.getParameter("movieCode");
		Movie movie = this.movies.get(movieCode);
		model.addAttribute("movie", movie);
		return "movieDetail";
	}
}
