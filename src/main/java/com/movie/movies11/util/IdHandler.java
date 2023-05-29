package com.movie.movies11.util;

public class IdHandler {
    public static String idExpandTo7(String oldId) {
        return String.format("%07d", Integer.valueOf(oldId));
    }
}
