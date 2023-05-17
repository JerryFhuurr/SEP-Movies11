package com.movie.movies11.service;

import com.movie.movies11.models.People;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeopleService {
    List<People> getAllPeople();
    List<People> getPeople(People people);
}
