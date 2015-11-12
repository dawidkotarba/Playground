package com.dawidkotarba.playground.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/db/*");
        return registrationBean;
    }
}
