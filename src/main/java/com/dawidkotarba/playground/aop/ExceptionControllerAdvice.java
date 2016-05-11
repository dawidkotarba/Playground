package com.dawidkotarba.playground.aop;

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
 * This advice catches all exceptions thrown by backend
 * and creates a localized user-readable {@link ExceptionResponse}.
 *
 * @author Dawid Kotarba
 * @see com.dawidkotarba.playground.service.i18n.LocalizationService
 * @see com.dawidkotarba.playground.exceptions.AbstractApplicationRuntimeException
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    private final ExceptionConverterService exceptionConverterService;

    @Autowired
    public ExceptionControllerAdvice(ExceptionConverterService exceptionConverterService) {
        this.exceptionConverterService = exceptionConverterService;
    }

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
