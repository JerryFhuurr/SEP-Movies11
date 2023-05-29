package com.movie.movies11.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    private int id;
    private String title;
    private int year;
    private String imagePath;
    private String language;
    private String genre;
    private String overview;
}
