package com.movie.movies11.service.serviceImpl;

import com.movie.movies11.models.Movie;
import com.movie.movies11.models.User;
import com.movie.movies11.service.UserService;
import com.movie.movies11.sqlMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getAUser(int userId, String username) {
        return userMapper.getAUser(userId, username);
    }

    @Override
    public String addAUser(User newUser) {

        userMapper.addAUser(newUser);
        return newUser.toString();
    }

    @Override
    public void updateAUser(User newUser) {
        User user = userMapper.getAUser(newUser.getUserId(), null);
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        userMapper.updateAUser(user);
    }

    @Override
    public List<Movie> getFavouriteList(int userId) {
        return userMapper.getFavouriteList(userId);
    }

    @Override
    public void addFMovieList(int userId, List<Integer> movieIds) {
        List<Movie> alreadyHaveMovies = userMapper.getFavouriteList(userId);
        List<Integer> haveIds = new ArrayList<>();
        for (Movie m : alreadyHaveMovies) {
            haveIds.add(m.getId());
        }
        movieIds.removeAll(haveIds);
        for (Integer movieId : movieIds) {
            userMapper.addFMovieList(userId, movieId);
        }
    }

    @Override
    public void removeFromMovieList(int userId, List<Integer> movieId) {
        for (Integer id : movieId) {
            userMapper.removeFromMovieList(userId, id);
        }
    }
}
