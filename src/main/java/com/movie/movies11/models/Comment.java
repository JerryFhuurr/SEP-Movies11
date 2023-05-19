package com.movie.movies11.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    private int cid;
    private String commentContext;
    private float rating;
    private User user;
    private Movie movie;
}
