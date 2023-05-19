package com.movie.movies11.service.serviceImpl;

import com.movie.movies11.models.User;
import com.movie.movies11.service.UserService;
import com.movie.movies11.sqlMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getAUser(int userId, String username) {
        return userMapper.getAUser(userId, username);
    }

    @Override
    public void addAUser(User newUser) {
        userMapper.addAUser(newUser);
    }

    @Override
    public void updateAUser(User newUser) {
        User user = userMapper.getAUser(newUser.getUserId(), null);
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        userMapper.updateAUser(user);
    }
}
