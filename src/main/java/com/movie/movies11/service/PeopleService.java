package com.movie.movies11.service;

import com.movie.movies11.models.People;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeopleService {
    List<People> getAllPeople();

    List<People> getPeople(int id, String name);

    People getDirectorByTitle(String movieTitle);

    People getDirectorById(int movieId);

    List<People> getActorsByMovie(String movieTitle);
}
