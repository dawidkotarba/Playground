package com.dawidkotarba.playground.config.ws;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Dawid Kotarba on 06.03.2016.
 */
@Configuration
@ImportResource({"classpath:META-INF/cxf/cxf.xml", "classpath:META-INF/cxf/cxf-servlet.xml"})
public class WsConfig {

    @Bean
    public ServletRegistrationBean cxfServlet() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(new CXFServlet(), "/ws/*");
        servlet.setLoadOnStartup(1);
        return servlet;
    }

    @Bean
    @Autowired
    public BeanPostProcessor wsEndpointFactoryPostProcessor(ApplicationContext applicationContext) {
        BeanPostProcessor wsPostProcessor = new WsEndpointFactoryPostProcessor(applicationContext, null);
        return wsPostProcessor;
    }
}
