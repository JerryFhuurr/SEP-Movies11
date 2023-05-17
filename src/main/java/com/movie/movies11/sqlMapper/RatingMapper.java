package com.movie.movies11.sqlMapper;

import com.movie.movies11.models.Rating;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RatingMapper {
    Rating getRating(int movieId);
    void addARating(Rating rating);
    void removeARating(Rating rating);
}
