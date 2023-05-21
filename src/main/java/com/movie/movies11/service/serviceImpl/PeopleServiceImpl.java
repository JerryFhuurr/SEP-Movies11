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
    public List<People> getPeople(People people) {
        return peopleMapper.getPeople(people);
    }

    @Override
    public People getDirector(String movieTitle) {
        return peopleMapper.getDirector(movieTitle);
    }

    @Override
    public List<People> getActorsByMovie(String movieTitle) {
        return peopleMapper.getActorsByMovie(movieTitle);
    }
}
