package com.movie.movies11.controller;

import com.movie.movies11.models.Rating;
import com.movie.movies11.service.RatingService;
import com.movie.movies11.service.validate.RatingValidate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/ratings/")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @GetMapping("getRating")
    public Rating getRating(int movieId) {
        return ratingService.getRating(movieId);
    }

    @PutMapping("insert/one/rating")
    public Rating addARating(@Validated(RatingValidate.class) @RequestBody Rating rating) {
        ratingService.addARating(rating);
        return ratingService.getRating(rating.getMovie().getId());
    }

    @PutMapping("remove/one/rating")
    public Rating removeARating(@Validated(RatingValidate.class) @RequestBody Rating rating) {
        ratingService.removeARating(rating);
        return ratingService.getRating(rating.getMovie().getId());
    }
}
