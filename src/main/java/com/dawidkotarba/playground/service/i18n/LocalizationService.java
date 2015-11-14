package com.dawidkotarba.playground.service.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by Dawid Kotarba on 14.11.2015.
 */

@Service
public class LocalizationService {

    @Autowired
    private MessageSource messageSource;

    @Value("${default.locale}")
    private String defaultLocaleStr;

    private Locale defaultLocale;

    @PostConstruct
    public void init() {
        defaultLocale = new Locale.Builder().setLanguageTag(defaultLocaleStr).build();
    }

    public String getMessage(String code) {
        return messageSource.getMessage(code, null, defaultLocale);
    }

    public String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, defaultLocale);
    }

}
