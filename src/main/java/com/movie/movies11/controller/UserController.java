package com.movie.movies11.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.movie.movies11.models.Movie;
import com.movie.movies11.models.User;
import com.movie.movies11.service.UserService;
import com.movie.movies11.service.validate.UserValidate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("getUser")
    public User getAUser(int id, String username) {
        return userService.getAUser(id, username);
    }

    @PostMapping("add/User")
    public User addAUser(@Validated(UserValidate.class) @RequestBody User newUser) {
        userService.addAUser(newUser);
        return userService.getAUser(newUser.getUserId(), newUser.getUsername());
    }

    @PutMapping("update/user")
    public User updateAUser(@Validated(UserValidate.class) @RequestBody User newUser) {
        userService.updateAUser(newUser);
        return userService.getAUser(newUser.getUserId(), newUser.getUsername());
    }

    @GetMapping("movieList/getList")
    public Object getFavouriteList(@RequestParam int userId, @RequestParam int pageNum, @RequestParam int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Movie> movies = userService.getFavouriteList(userId);
        return new PageInfo<>(movies);
    }

    @PostMapping("movieList/addToMovie")
    public List<Movie> addFMovieList(int userId, @Validated(UserValidate.class) @RequestBody List<Integer> ids) {
        userService.addFMovieList(userId, ids);
        return userService.getFavouriteList(userId);
    }

    @DeleteMapping("movieList/removeMovie")
    public String removeFromMovieList(int userId, @Validated(UserValidate.class) @RequestBody List<Integer> movieId) {
        userService.removeFromMovieList(userId, movieId);
        return movieId.size() + " movies has been removed from list.";
    }
}
