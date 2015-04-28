package com.soni.controller;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soni.model.Movie;
import com.soni.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method=RequestMethod.GET, value="/movieDetailsForm")
	public String movieDetailsForm() {
		return "movieDetailsForm.def";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/showMovieDetails")
	public String showDetails(Model model, HttpServletRequest request){
		String movieCode = request.getParameter("movieCode");
		Movie movie = movieService.getMovieByMovieCode(movieCode);
		model.addAttribute("movie", movie);
		return "movieDetail";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/addNewMoviesForm")
	public String addNewMoviesForm(){
		return "addNewMoviesForm.def";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addNewMovies")
	public @ResponseBody String addNewMovies(@RequestParam String moviesCsv, HttpServletResponse res) throws Exception{
		List<String> newMovies = Arrays.asList(moviesCsv.split(","));
		List<String> allMovieTitles = movieService.addNewMovies(newMovies);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(allMovieTitles);
	}
}
