package com.movie.movies11.exception;

import lombok.Getter;
import lombok.Setter;

public class DbExceptionClass extends RuntimeException {
    public static final Integer DEFAULT_ERROR_CODE = 0;
    public static final String DEFAULT_ERROR_MSG = "Internal error";

    @Getter
    @Setter
    private Integer code;

    public DbExceptionClass(Integer code) {
        super(DEFAULT_ERROR_MSG);
        this.code = code;
    }

    public DbExceptionClass(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public DbExceptionClass(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
