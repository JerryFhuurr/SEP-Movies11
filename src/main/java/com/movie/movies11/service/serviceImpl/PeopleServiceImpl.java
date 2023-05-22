package com.movie.movies11.service.serviceImpl;

import com.movie.movies11.models.People;
import com.movie.movies11.service.PeopleService;
import com.movie.movies11.sqlMapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    PeopleMapper peopleMapper;

    @Override
    public List<People> getAllPeople() {
        return peopleMapper.getAllPeople();
    }

    @Override
    public List<People> getPeople(int id, String name) {
        return peopleMapper.getPeople(id, name);
    }

    @Override
    public People getDirectorByTitle(String movieTitle) {
        return peopleMapper.getDirectorByTitle(movieTitle);
    }

    @Override
    public People getDirectorById(int movieId) {
        return peopleMapper.getDirectorById(movieId);
    }

    @Override
    public List<People> getActorsByMovie(String movieTitle) {
        return peopleMapper.getActorsByMovie(movieTitle);
    }
}
