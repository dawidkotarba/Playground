package com.dawidkotarba.playground.service;

import com.dawidkotarba.playground.enums.ExceptionType;
import com.dawidkotarba.playground.exceptions.ApplicationRuntimeException;
import com.dawidkotarba.playground.integration.dto.ExceptionResponse;
import com.dawidkotarba.playground.service.i18n.LocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Dawid Kotarba on 14.11.2015.
 */

@Service
public class ExceptionConverterService {

    @Autowired
    private LocalizationService localizationService;

    public ExceptionResponse convert(ApplicationRuntimeException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setUuid(e.getUuid());
        exceptionResponse.setExceptionType(e.getExceptionType());
        exceptionResponse.setUserMessage(getLocalizedUserMessage(e.getExceptionType(), e.getParams()));
        exceptionResponse.setDevMessage(e.getMessage());

        return exceptionResponse;
    }

    public ExceptionResponse convert(Exception e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setUuid(UUID.randomUUID());
        exceptionResponse.setExceptionType(ExceptionType.INTERNAL_ERROR);
        exceptionResponse.setUserMessage(getLocalizedUserMessage(ExceptionType.INTERNAL_ERROR));
        exceptionResponse.setDevMessage(e.getMessage());

        return exceptionResponse;
    }


    private String getLocalizedUserMessage(ExceptionType exceptionType) {
        return getLocalizedUserMessage(exceptionType, null);
    }

    private String getLocalizedUserMessage(ExceptionType exceptionType, String[] params) {
        return (params != null) ? localizationService.getMessage(exceptionType.name(), params) : localizationService.getMessage(exceptionType.name());
    }
}
