package com.movie.movies11.sqlMapper;

import com.movie.movies11.models.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieMapper {
    List<Movie> getAllMovies();

    Movie getOneMovieById(int id);

    List<Movie> getMovies(@Param("id") int id, @Param("title") String title);

    List<Movie> getMoviesByLimit(@Param("number") int number);
}
