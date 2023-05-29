package com.movie.movies11.service;

import com.movie.movies11.models.Movie;
import com.movie.movies11.models.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User getAUser(int userId, String username);

    String userLogin(String username, String password);

    List<String> getAllUsername();

    void addAUser(User newUser);

    void updateAUser(User newUser);

    List<Movie> getFavouriteList(int userId);

    void addFMovieList(int userId, List<Integer> movieIds);

    void removeFromMovieList(int userId, List<Integer> movieId);
}
