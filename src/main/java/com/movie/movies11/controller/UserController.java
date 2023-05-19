package com.movie.movies11.controller;

import com.movie.movies11.models.User;
import com.movie.movies11.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("getUser")
    public User getAUser(@RequestBody User user) {
        return userService.getAUser(user.getUserId(), user.getUsername());
    }

    @PostMapping("add/User")
    public User addAUser(@RequestBody User newUser) {
        userService.addAUser(newUser);
        return userService.getAUser(newUser.getUserId(), newUser.getUsername());
    }

    @PutMapping("update/user")
    public User updateAUser(@RequestBody User newUser) {
        userService.updateAUser(newUser);
        return userService.getAUser(newUser.getUserId(), newUser.getUsername());
    }

}
