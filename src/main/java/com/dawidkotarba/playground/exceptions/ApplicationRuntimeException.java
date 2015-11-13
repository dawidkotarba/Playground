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

    private void init(ExceptionType exceptionType) {
        uuid = UUID.randomUUID();
        this.exceptionType = exceptionType;
    }

    public ApplicationRuntimeException(ExceptionType exceptionType, String message) {
        super(message);
        init(exceptionType);
    }

    public ApplicationRuntimeException(ExceptionType exceptionType, Throwable cause) {
        super(cause);
        init(exceptionType);
    }

    public ApplicationRuntimeException(ExceptionType exceptionType, String message, Throwable cause) {
        super(message, cause);
        init(exceptionType);
    }

    public ApplicationRuntimeException addParams(String... params) {
        this.params = params;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String[] getParams() {
        return params;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }
}
