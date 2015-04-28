package com.soni.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
