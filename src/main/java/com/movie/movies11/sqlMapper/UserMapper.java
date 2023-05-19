package com.movie.movies11.sqlMapper;

import com.movie.movies11.models.Movie;
import com.movie.movies11.models.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User getAUser(int userId, String username);
    void addAUser(User newUser);
    void updateAUser(User newUser);
    List<Movie> getFavouriteList(int userId);
    void addFMovieList(@Param("userId") int userId, @Param("movieId") Integer movieId);
    void removeFromMovieList(@Param("userId") int userId, @Param("movieId") Integer movieId);
}
