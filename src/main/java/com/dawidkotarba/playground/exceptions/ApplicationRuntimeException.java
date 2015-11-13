package com.dawidkotarba.playground.exceptions;

import com.dawidkotarba.playground.enums.ExceptionType;

import java.util.UUID;

/**
 * Created by Dawid Kotarba on 13.11.2015.
 */
public abstract class ApplicationRuntimeException extends RuntimeException {

    private UUID uuid;
    private String[] params;
    private ExceptionType exceptionType;

    private void init() {
        uuid = UUID.randomUUID();
    }

    public ApplicationRuntimeException(ExceptionType exceptionType, String message) {
        super(message);
        init();
    }

    public ApplicationRuntimeException(ExceptionType exceptionType, Throwable cause) {
        super(cause);
        init();
    }

    public ApplicationRuntimeException(ExceptionType exceptionType, String message, Throwable cause) {
        super(message, cause);
        init();
    }

    public ApplicationRuntimeException addParams(ExceptionType exceptionType, String... params) {
        this.params = params;
        return this;
    }
}
