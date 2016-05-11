package com.dawidkotarba.playground.service.i18n;

import com.dawidkotarba.playground.config.LocalizationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 * Created by Dawid Kotarba on 14.11.2015.
 */

@Service
public class LocalizationService {

    private final MessageSource messageSource;
    private final LocalizationConfig localizationConfig;

    @Autowired
    public LocalizationService(MessageSource messageSource, LocalizationConfig localizationConfig) {
        this.messageSource = messageSource;
        this.localizationConfig = localizationConfig;
    }

    public String getMessage(String code) {
        return messageSource.getMessage(code, null, localizationConfig.getDefaultLocale());
    }

    public String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, localizationConfig.getDefaultLocale());
    }
}
