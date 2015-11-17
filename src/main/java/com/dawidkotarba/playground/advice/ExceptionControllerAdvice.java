package com.dawidkotarba.playground.advice;

import com.dawidkotarba.playground.exceptions.InternalErrorException;
import com.dawidkotarba.playground.exceptions.NotFoundException;
import com.dawidkotarba.playground.integration.exceptions.ExceptionResponse;
import com.dawidkotarba.playground.service.ExceptionConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Dawid Kotarba on 13.11.2015.
 */

@ControllerAdvice
public class ExceptionControllerAdvice {

    @Autowired
    private ExceptionConverterService exceptionConverterService;

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse handleException(Exception e) {
        return exceptionConverterService.convert(e);
    }

    @ExceptionHandler(value = InternalErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse handleException(InternalErrorException e) {
        return exceptionConverterService.convert(e);
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionResponse handleException(NotFoundException e) {
        return exceptionConverterService.convert(e);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse handleException(MethodArgumentNotValidException e) {
        return exceptionConverterService.convert(e, e.getBindingResult());
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse handleException(BindException e) {
        return exceptionConverterService.convert(e, e.getBindingResult());
    }
}
