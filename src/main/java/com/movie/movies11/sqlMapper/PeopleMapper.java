package com.movie.movies11.sqlMapper;

import com.movie.movies11.models.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PeopleMapper {
    List<People> getAllPeople();

    List<People> getPeople(@Param("id") int id, @Param("name") String name);

    People getDirectorByTitle(String movieTitle);

    People getDirectorById(int movieId);

    List<People> getActorsByMovie(String movieTitle);

}
