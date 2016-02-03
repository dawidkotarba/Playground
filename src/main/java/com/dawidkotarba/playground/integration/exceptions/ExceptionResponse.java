package com.dawidkotarba.playground.integration.exceptions;

import com.dawidkotarba.playground.enums.ExceptionType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Dawid Kotarba on 14.11.2015.
 */
@Data
public class ExceptionResponse {

    private UUID uuid;
    private ExceptionType exceptionType;
    private String userMessage;
    private String devMessage;
    private List<ValidationError> validationErrors = new ArrayList<>();
}
