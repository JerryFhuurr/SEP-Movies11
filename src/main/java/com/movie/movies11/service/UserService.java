package com.movie.movies11.service;

import com.movie.movies11.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getAUser(int userId, String username);
    void addAUser(User newUser);
    void updateAUser(User newUser);
}
