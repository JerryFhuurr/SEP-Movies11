package com.movie.movies11.service;

import com.movie.movies11.models.Movie;
import org.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface MoviesService {
    List<Movie> getAllMovies();

    List<Movie> getMoviesByGenre(String genre);

    Movie getOneMovieById(int id);

    List<Movie> getMovies(int id, String title);

    List<Movie> getByYear(int year);

    String getImage(String id);

    String getOverview(String id);

    String getLanguage(String id);

    String getCountry(String id);

    String getGenres(String id);

    String getListByGenre(int genreId,int page);
}
