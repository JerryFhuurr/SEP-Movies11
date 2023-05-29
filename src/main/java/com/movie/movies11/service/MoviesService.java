package com.movie.movies11.service;

import com.movie.movies11.models.Movie;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MoviesService {
    List<Movie> getAllMovies();

    Movie getOneMovieById(int id);

    List<Movie> getMovies(int id, String title);

    String getImage(int id) throws JSONException;
}
