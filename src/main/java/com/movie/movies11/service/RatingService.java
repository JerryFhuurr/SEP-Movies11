package com.movie.movies11.service;

import com.movie.movies11.models.Rating;
import org.springframework.stereotype.Service;

@Service
public interface RatingService {
    Rating getRating(int movieId);
    void addARating(Rating rating);
    void removeARating(Rating rating);
}
