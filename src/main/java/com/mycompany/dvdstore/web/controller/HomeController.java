package com.mycompany.dvdstore.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.IMovieService;
import com.mycompany.dvdstore.web.form.MovieForm;

@Controller
public class HomeController {
	
	@Autowired
	private IMovieService movieService;
	
	public IMovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(IMovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/dvdstore-home")
	public void displayHome()
	{
		//@ModelAttribute("movies") List<Movie>
		//return  movieService.getMovieList();
	}
	
	@GetMapping("/add-movie-form")
	public void displayMovieForm(@ModelAttribute("movieForm") MovieForm movie)
	{
		
	}

}
