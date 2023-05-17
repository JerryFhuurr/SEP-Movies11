package com.movie.movies11.sqlMapper;

import com.movie.movies11.models.People;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PeopleMapper {
    List<People> getAllPeople();
    List<People> getPeople(People people);
    People getDirector(String movieTitle);
    List<People> getActorsByMovie(String movieTitle);

}
