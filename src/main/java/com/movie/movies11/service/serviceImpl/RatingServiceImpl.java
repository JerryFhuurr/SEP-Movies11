package com.movie.movies11.service.serviceImpl;

import com.movie.movies11.models.Rating;
import com.movie.movies11.service.RatingService;
import com.movie.movies11.sqlMapper.RatingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ratingService")
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingMapper ratingMapper;
    @Override
    public Rating getRating(int movieId) {
        return ratingMapper.getRating(movieId);
    }

    @Override
    public void addARating(Rating rating) {
        ratingMapper.addARating(rating);
    }

    @Override
    public void removeARating(Rating rating) {
        ratingMapper.removeARating(rating);
    }
}
