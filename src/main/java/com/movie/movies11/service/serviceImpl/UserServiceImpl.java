package com.movie.movies11.service.serviceImpl;

import com.movie.movies11.exception.DbExceptionClass;
import com.movie.movies11.exception.ErrorCode;
import com.movie.movies11.models.Movie;
import com.movie.movies11.models.User;
import com.movie.movies11.service.MoviesService;
import com.movie.movies11.service.UserService;
import com.movie.movies11.sqlMapper.UserMapper;
import com.movie.movies11.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    MoviesService moviesService;

    @Override
    public User getAUser(int userId, String username) {
        try {
            return userMapper.getAUser(userId, username);
        } catch (Exception e) {
            String msg = "User is not existed";
            throw new DbExceptionClass(ErrorCode.User.USER_NOT_EXISTED, msg);
        }
    }

    @Override
    public String userLogin(String username, String password) {
        User userGet;
        try {
            userGet = userMapper.getUserByName(username);
            if (userGet == null) {
                return "Cannot find user";
            } else {
                String passwordAfter = MD5Util.inputPassToFormPass(password);
                if (username.equals(userGet.getUsername()) &&
                        passwordAfter.equals(userGet.getPassword())) {
                    return "Login success";
                } else {
                    return "Login fail";
                }
            }
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public List<String> getAllUsername() {
        return userMapper.getAllUsername();
    }

    @Override
    public void addAUser(User newUser) {
        if (usernameAlreadyExisted(newUser.getUsername())) {
            String errorMsg = "Username is already existed";
            throw new DbExceptionClass(ErrorCode.User.USER_USERNAME_ERROR, errorMsg);
        } else {
            newUser.setPassword(MD5Util.inputPassToFormPass(newUser.getPassword()));
            userMapper.addAUser(newUser);
        }
    }

    @Override
    public void updateAUser(User newUser) {
        User user = userMapper.getAUser(newUser.getUserId(), null);
        if (usernameAlreadyExisted(newUser.getUsername()) && !Objects.equals(newUser.getUsername(), user.getUsername())) {
            String errorMsg = "Username is already existed";
            throw new DbExceptionClass(ErrorCode.User.USER_USERNAME_ERROR, errorMsg);
        } else {
            user.setUsername(newUser.getUsername());
            user.setPassword(MD5Util.inputPassToFormPass(newUser.getPassword()));
            userMapper.updateAUser(user);
        }
    }

    @Override
    public List<Movie> getFavouriteList(int userId) {
        List<Movie> movies = userMapper.getFavouriteList(userId);
        for (Movie m : movies) {
            m.setImagePath(moviesService.getImage(String.valueOf(m.getId())));
            m.setCountry(moviesService.getCountry(String.valueOf(m.getId())));
            m.setGenre(moviesService.getGenres(String.valueOf(m.getId())));
            m.setLanguage(moviesService.getLanguage(String.valueOf(m.getId())));
            m.setOverview(moviesService.getOverview(String.valueOf(m.getId())));
        }
        return movies;
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
            try {
                userMapper.addFMovieList(userId, movieId);
            } catch (Exception e) {
                removeFromMovieList(userId, movieIds);
                String msg = "Movie error";
                throw new DbExceptionClass(ErrorCode.User.USER_MOVIElIST_ADD_NOT_EXISTED, msg);
            }
        }
    }

    @Override
    public void removeFromMovieList(int userId, List<Integer> movieId) {
        for (Integer id : movieId) {
            userMapper.removeFromMovieList(userId, id);
        }
    }

    public boolean usernameAlreadyExisted(String username) {
        List<String> usernames = getAllUsername();
        return usernames.contains(username);
    }
}
