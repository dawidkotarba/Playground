package com.dawidkotarba.playground.exceptions;

import com.dawidkotarba.playground.enums.ExceptionType;

/**
 * Created by Dawid Kotarba on 13.11.2015.
 */
public class NotFoundException extends AbstractApplicationRuntimeException {

    public NotFoundException(String message) {
        super(ExceptionType.NOT_FOUND, message);
    }

    public NotFoundException(Throwable cause) {
        super(ExceptionType.NOT_FOUND, cause);
    }

    public NotFoundException(String message, Throwable cause) {
        super(ExceptionType.NOT_FOUND, message, cause);
    }
}
