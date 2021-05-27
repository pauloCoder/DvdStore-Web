package com.mycompany.dvdstore.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.dvdstore.core.service.IMovieService;

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

	@RequestMapping("/{id}")
	public ModelAndView displayMovieCard(@PathVariable("id") Long id)
	{
		ModelAndView mv = new ModelAndView("movie-details");
		mv.addObject("movie" , movieService.getMovieById(id));
		return mv;
	}

}
