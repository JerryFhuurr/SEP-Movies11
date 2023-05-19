package com.movie.movies11.sqlMapper;

import com.movie.movies11.models.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getAUser(int userId, String username);
    void addAUser(User newUser);
    void updateAUser(User newUser);
}
