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
public class Comment {
    private int cid;
    private String commentContext;
    private float rating;
    @NotNull(message = "User info cannot be null in comment")
    @NotBlank(message = "User info cannot be null in comment")
    private User user;
    @NotNull(message = "Movie info cannot be null in comment")
    @NotBlank(message = "Movie info cannot be null in comment")
    private Movie movie;
}
