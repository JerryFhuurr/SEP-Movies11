package com.movie.movies11.service.serviceImpl;

import com.movie.movies11.util.IdHandler;
import com.movie.movies11.util.TMDbAPI;
import com.movie.movies11.models.Movie;
import com.movie.movies11.service.MoviesService;
import com.movie.movies11.sqlMapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addProperties() {
        List<Movie> list = movieMapper.getAllMovies();
        for (Movie m : list) {
            String id = String.valueOf(m.getId());
            String imagePath = getImage(id);
            String language = getLanguage(id);
            String country = getCountry(id);
            String genre = getGenres(id);
            String overview = getOverview(id);
            if (imagePath.contains("not found")) {
                imagePath = "N/A";
            }
            if (language.contains("not found")) {
                language = "N/A";
            }
            if (imagePath.contains("not found")) {
                imagePath = "N/A";
            }
            if (genre.contains("not found")) {
                genre = "N/A";
            }
            if (overview.contains("not found")) {
                overview = "N/A";
            }
            if (country.contains("not found")) {
                country = "N/A";
            }
            movieMapper.addExtraProperties(m.getId(), imagePath, language, country, genre, overview);
        }
    }

}
