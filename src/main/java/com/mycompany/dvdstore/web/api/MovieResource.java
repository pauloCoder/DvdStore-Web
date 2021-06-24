package com.mycompany.dvdstore.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.IMovieService;

@RestController
@RequestMapping("/movie")
public class MovieResource 
{
	@Autowired
	private IMovieService movieService;
	
	public IMovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(IMovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("")
	public Iterable<Movie> list()
	{
		return  movieService.getMovieList();
	}

	@GetMapping("/{id}")
	public Movie get(@PathVariable("id") Long id)
	{
		return movieService.getMovieById(id);
	}
	
	@PostMapping("")
	public Movie add(@RequestBody Movie movie)
	{ 
		return movieService.registerMovie(movie);
	}

}
