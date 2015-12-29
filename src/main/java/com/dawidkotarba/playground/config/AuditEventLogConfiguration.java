package com.dawidkotarba.playground.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;

/**
 * Created by Dawid Kotarba on 28.12.2015.
 */

@Configuration
public class AuditEventLogConfiguration implements ApplicationListener<AbstractAuthenticationEvent> {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent event) {
        LOGGER.info("Authentication event: " + event);
    }
}
