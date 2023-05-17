package com.movie.movies11.controller;

import com.movie.movies11.models.Movie;
import com.movie.movies11.models.People;
import com.movie.movies11.service.MoviesService;
import com.movie.movies11.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/people/")
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    @GetMapping("getAll")
    public List<People> getAllPeople() {
        return peopleService.getAllPeople();
    }

    @GetMapping("getSome")
    public List<People> getPeopleByIdOrName(@RequestBody People people) {
        return peopleService.getPeople(people);
    }

    @GetMapping("getDirector")
    public People getDirector(String movieTitle) {
        return peopleService.getDirector(movieTitle);
    }

    @GetMapping("getActors")
    public List<People> getActorsByMovie(String movieTitle) {
        return peopleService.getActorsByMovie(movieTitle);
    }
}
