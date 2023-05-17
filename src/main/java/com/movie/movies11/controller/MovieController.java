package com.movie.movies11.controller;

import com.movie.movies11.models.Movie;
import com.movie.movies11.service.MoviesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movie/")
public class MovieController {
    @Autowired
    MoviesService moviesService;

    @GetMapping("getAll")
    List<Movie> getALlMovies() {
        return moviesService.getAllMovies();
    }

    @GetMapping("getOne")
    Movie getOneMovieById(int id) {
        return moviesService.getOneMovieById(id);
    }

    @GetMapping("getByProperties")
    List<Movie> getByProperties(@RequestBody Movie movie) {
        return moviesService.getMovies(movie);
    }
}