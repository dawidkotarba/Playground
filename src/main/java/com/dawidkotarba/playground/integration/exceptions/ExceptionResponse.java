package com.dawidkotarba.playground.integration.exceptions;

import com.dawidkotarba.playground.enums.ExceptionType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Dawid Kotarba on 14.11.2015.
 */
public class ExceptionResponse {

    private UUID uuid;
    private ExceptionType exceptionType;
    private String userMessage;
    private String devMessage;
    private List<ValidationError> validationErrors = new ArrayList<>();

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
