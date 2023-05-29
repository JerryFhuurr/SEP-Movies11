package com.movie.movies11.service.serviceImpl;

import com.movie.movies11.TMDbAPI;
import com.movie.movies11.models.Movie;
import com.movie.movies11.service.MoviesService;
import com.movie.movies11.sqlMapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("moviesService")
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    MovieMapper movieMapper;

    @Override
    public List<Movie> getAllMovies() {
        return movieMapper.getAllMovies();
    }

    @Override
    public Movie getOneMovieById(int id) {
        return movieMapper.getOneMovieById(id);
    }

    @Override
    public List<Movie> getMovies(int id, String title) {
        return movieMapper.getMovies(id, title);
    }

    @Override public String getImage(int id) throws JSONException
    {
        TMDbAPI tmDbAPI = new TMDbAPI();
        return tmDbAPI.getPosterPath(id);
    }

    @Override public String getOverview(int id) throws JSONException
    {
        TMDbAPI tmDbAPI = new TMDbAPI();
        return tmDbAPI.getOverview(id);
    }

}
