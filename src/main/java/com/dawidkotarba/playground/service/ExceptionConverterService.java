package com.dawidkotarba.playground.service;

import com.dawidkotarba.playground.enums.ExceptionType;
import com.dawidkotarba.playground.exceptions.ApplicationRuntimeException;
import com.dawidkotarba.playground.integration.exceptions.ExceptionResponse;
import com.dawidkotarba.playground.integration.exceptions.ValidationError;
import com.dawidkotarba.playground.service.i18n.LocalizationService;
import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Dawid Kotarba on 14.11.2015.
 */

@Service
public class ExceptionConverterService {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LocalizationService localizationService;

    public ExceptionResponse convert(ApplicationRuntimeException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setUuid(e.getUuid());
        exceptionResponse.setExceptionType(e.getExceptionType());
        exceptionResponse.setUserMessage(getLocalizedUserMessage(e.getExceptionType(), e.getParams()));
        exceptionResponse.setDevMessage(e.getMessage());
        LOGGER.error(Throwables.getStackTraceAsString(e));

        return exceptionResponse;
    }

    public ExceptionResponse convert(Exception e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setUuid(UUID.randomUUID());
        exceptionResponse.setExceptionType(ExceptionType.INTERNAL_ERROR);
        exceptionResponse.setUserMessage(getLocalizedUserMessage(ExceptionType.INTERNAL_ERROR));
        exceptionResponse.setDevMessage(e.getMessage());
        LOGGER.error(Throwables.getStackTraceAsString(e));

        return exceptionResponse;
    }

    public ExceptionResponse convert(Exception e, BindingResult bindingResult) {
        ExceptionResponse exceptionResponse = convert(e);
        exceptionResponse.getValidationErrors().addAll(parseBindingResult(bindingResult));
        return exceptionResponse;
    }

    private String getLocalizedUserMessage(ExceptionType exceptionType) {
        return getLocalizedUserMessage(exceptionType, null);
    }

    private String getLocalizedUserMessage(ExceptionType exceptionType, String[] params) {
        return (params != null) ? localizationService.getMessage(exceptionType.name(), params) : localizationService.getMessage(exceptionType.name());
    }

    private List<ValidationError> parseBindingResult(BindingResult bindingResult) {
        List<ValidationError> validationErrors = new ArrayList<>();

        bindingResult.getFieldErrors().forEach(fieldError ->
                        validationErrors.add(new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()))
        );

        return validationErrors;
    }
}
