package com.movie.movies11.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.movie.movies11.models.Movie;
import com.movie.movies11.service.MoviesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/movie/")
public class MovieController {
    @Autowired
    MoviesService moviesService;

    @GetMapping("getAll")
    Object getALlMovies(@RequestParam int pageNum, @RequestParam int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Movie> movies = moviesService.getAllMovies();
        for (Movie m : movies) {
            m.setImagePath(moviesService.getImage(String.valueOf(m.getId())));
            m.setCountry(moviesService.getCountry(String.valueOf(m.getId())));
            m.setGenre(moviesService.getGenres(String.valueOf(m.getId())));
            m.setLanguage(moviesService.getLanguage(String.valueOf(m.getId())));
            m.setOverview(moviesService.getOverview(String.valueOf(m.getId())));
        }
        // total page : 26190 (10 items in one page)
        // total movie number : 261900
        return new PageInfo<>(movies);
    }

    @GetMapping("getOne")
    Movie getOneMovieById(int id) {
        Movie m = moviesService.getOneMovieById(id);
        m.setImagePath(moviesService.getImage(String.valueOf(m.getId())));
        m.setCountry(moviesService.getCountry(String.valueOf(m.getId())));
        m.setGenre(moviesService.getGenres(String.valueOf(m.getId())));
        m.setLanguage(moviesService.getLanguage(String.valueOf(m.getId())));
        m.setOverview(moviesService.getOverview(String.valueOf(m.getId())));
        return m;
    }

    @GetMapping("getByIdTitle")
    Object getByProperties(int id, String title, @RequestParam int pageNum, @RequestParam int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Movie> moviesGet = moviesService.getMovies(id, title);
        for (Movie m : moviesGet) {
            m.setImagePath(moviesService.getImage(String.valueOf(m.getId())));
            m.setCountry(moviesService.getCountry(String.valueOf(m.getId())));
            m.setGenre(moviesService.getGenres(String.valueOf(m.getId())));
            m.setLanguage(moviesService.getLanguage(String.valueOf(m.getId())));
            m.setOverview(moviesService.getOverview(String.valueOf(m.getId())));
        }
        return new PageInfo<>(moviesGet);
    }

    @GetMapping("getByGenre")
    List<Movie> getMoviesByGenre(String genre) {
        List<Movie> movies = moviesService.getMoviesByGenre(genre);
        for (Movie m : movies) {
            m.setImagePath(moviesService.getImage(String.valueOf(m.getId())));
            m.setCountry(moviesService.getCountry(String.valueOf(m.getId())));
            m.setGenre(moviesService.getGenres(String.valueOf(m.getId())));
            m.setLanguage(moviesService.getLanguage(String.valueOf(m.getId())));
            m.setOverview(moviesService.getOverview(String.valueOf(m.getId())));
        }
        return movies;
    }

    @GetMapping("getByYear")
    Object getByYear(int year, @RequestParam int pageNum, @RequestParam int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Movie> movies = moviesService.getByYear(year);
        for (Movie m : movies) {
            m.setImagePath(moviesService.getImage(String.valueOf(m.getId())));
            m.setCountry(moviesService.getCountry(String.valueOf(m.getId())));
            m.setGenre(moviesService.getGenres(String.valueOf(m.getId())));
            m.setLanguage(moviesService.getLanguage(String.valueOf(m.getId())));
            m.setOverview(moviesService.getOverview(String.valueOf(m.getId())));
        }
        // total page : 26190 (10 items in one page)
        // total movie number : 261900
        return new PageInfo<>(movies);
    }

    @GetMapping("getImage")
    String getImage(String id) {
        return moviesService.getImage(id);
    }

    @GetMapping("getOverview")
    String getOverview(String id) {
        return moviesService.getOverview(id);
    }

    @GetMapping("getLanguage")
    String getLanguage(String id) {
        return moviesService.getLanguage(id);
    }

    @GetMapping("getCountry")
    String getCountry(String id) {
        return moviesService.getCountry(id);
    }

    @GetMapping("getGenres")
    String getGenres(String id) {
        return moviesService.getGenres(id);
    }

    @GetMapping("getGenresId")
    ArrayList<Integer> getGenresId(String id) {
        return moviesService.getGenresId(id);
    }

    @GetMapping("getListByGenre")
    String getListByGenre(int id,int page) {
        return moviesService.getListByGenre(id,page);
    }
}
