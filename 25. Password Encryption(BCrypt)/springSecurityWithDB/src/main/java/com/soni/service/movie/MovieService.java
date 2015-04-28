package com.soni.service.movie;

import java.util.List;
import java.util.Map;

import com.soni.model.Movie;

public interface MovieService {
	public Map<String, Movie> getAllMovies();
	public Movie getMovieByMovieCode(String movieCode);
	public String getDirectorName();
	public List<String> addNewMovies(List<String> newMovies);
}
