package com.movie.movies11.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    private float ratings;
    private int votes;
    @NotNull(message = "Movie cannot be null in rating")
    @NotBlank(message = "Movie cannot be null in rating")
    private Movie movie;
}
