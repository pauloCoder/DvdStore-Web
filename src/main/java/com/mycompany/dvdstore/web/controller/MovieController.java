package com.mycompany.dvdstore.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.IMovieService;
import com.mycompany.dvdstore.web.form.MovieForm;

@Controller
@RequestMapping("/movie")
public class MovieController 
{
	@Autowired
	private IMovieService movieService;
	
	public IMovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(IMovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/{id}")
	public ModelAndView displayMovieCard(@PathVariable("id") Long id)
	{
		ModelAndView mv = new ModelAndView("movie-details");
		mv.addObject("movie" , movieService.getMovieById(id));
		return mv;
	}
	
	@PostMapping("")
	public String addMovie(@Valid @ModelAttribute("movieForm") MovieForm movieForm , BindingResult results)
	{
		
		if (results.hasErrors())
		{
			return "add-movie-form";
		}
		
		Movie movie = new Movie();
		movie.setId(movieForm.getId());
		movie.setTitle(movieForm.getTitle());
		movie.setGenre(movieForm.getGenre());
		movie.setDescription(movieForm.getDescription()); 
		movieService.registerMovie(movie);
		return "movie-added";
	}

}
