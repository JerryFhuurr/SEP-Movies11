package com.movie.movies11.service.serviceImpl;

import com.movie.movies11.util.IdHandler;
import com.movie.movies11.util.TMDbAPI;
import com.movie.movies11.models.Movie;
import com.movie.movies11.service.MoviesService;
import com.movie.movies11.sqlMapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Movie> getMoviesByGenre(String genre) {
        List<Movie> movies = movieMapper.getMoviesByLimit(100);
        for (Movie m : movies) {
            m.setGenre(getGenres(String.valueOf(m.getId())));
        }
        List<Movie> results = new ArrayList<>();
        for (Movie m : movies) {
            if (m.getGenre().contains(genre)) {
                results.add(m);
            }
        }
        return results;
    }

    @Override
    public Movie getOneMovieById(int id) {
        return movieMapper.getOneMovieById(id);
    }

    @Override
    public List<Movie> getMovies(int id, String title) {
        return movieMapper.getMovies(id, title);
    }

    @Override
    public String getImage(String id) {
        try {
            id = IdHandler.idExpandTo7(id);
            TMDbAPI tmDbAPI = new TMDbAPI();
            return tmDbAPI.getPosterPath(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String getOverview(String id) {
        try {
            id = IdHandler.idExpandTo7(id);
            TMDbAPI tmDbAPI = new TMDbAPI();
            return tmDbAPI.getOverview(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String getLanguage(String id) {
        try {
            id = IdHandler.idExpandTo7(id);
            TMDbAPI tmDbAPI = new TMDbAPI();
            return tmDbAPI.getLanguage(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String getCountry(String id) {
        try {
            id = IdHandler.idExpandTo7(id);
            TMDbAPI tmDbAPI = new TMDbAPI();
            return tmDbAPI.getCountry(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String getGenres(String id) {
        try {
            id = IdHandler.idExpandTo7(id);
            TMDbAPI tmDbAPI = new TMDbAPI();
            return tmDbAPI.getGenres(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public ArrayList<Integer> getGenresId(String id) {
        try {
            id = IdHandler.idExpandTo7(id);
            TMDbAPI tmDbAPI = new TMDbAPI();
            return tmDbAPI.getGenresId(id);
        } catch (Exception e) {
            return null;
        }
    }

}
