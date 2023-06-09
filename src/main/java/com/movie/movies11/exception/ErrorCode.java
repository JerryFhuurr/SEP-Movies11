package com.movie.movies11.exception;

public class ErrorCode {
    public static class Comment {
        public static final Integer COMMENT_ALREADY_EXISTED = 101;
        public static final Integer COMMENT_NOT_EXISTED = 102;

    }

    public static class User {
        public static final Integer USER_NOT_EXISTED = 201;
        public static final Integer USER_USERNAME_ERROR = 202;
        public static final Integer USER_MOVIElIST_ADD_NOT_EXISTED = 203;
    }

    public static class Rating {
        public static final Integer RATING_NUMBER_OVER_RANGE = 301;
    }
}
