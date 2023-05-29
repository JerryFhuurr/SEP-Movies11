package com.movie.movies11.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.movie.movies11.models.Movie;
import com.movie.movies11.service.MoviesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        // total page : 26190 (10 items in one page)
        // total movie number : 261900
        return new PageInfo<>(movies);
    }

    @GetMapping("getOne")
    Movie getOneMovieById(int id) {
        return moviesService.getOneMovieById(id);
    }

    @GetMapping("getByIdTitle")
    Object getByProperties(int id, String title, @RequestParam int pageNum, @RequestParam int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Movie> moviesGet = moviesService.getMovies(id, title);
        return new PageInfo<>(moviesGet);
    }

    @GetMapping("getImage")
    String getImage(String id)
    {
        return moviesService.getImage(id);
    }

    @GetMapping("getOverview")
    String getOverview(String id)
    {
        return moviesService.getOverview(id);
    }

    @GetMapping("getLanguage")
    String getLanguage(String id)
    {
        return moviesService.getLanguage(id);
    }

    @GetMapping("getCountry")
    String getCountry(String id)
    {
        return moviesService.getCountry(id);
    }

    @GetMapping("getGenres")
    String getGenres(String id)
    {
        return moviesService.getGenres(id);
    }

    @PostMapping("add/p")
    void addP() {
        moviesService.addProperties();
    }
}
