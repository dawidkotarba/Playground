package com.dawidkotarba.playground.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */
@Configuration
@ComponentScan("com.dawidkotarba.playground")
@EnableConfigurationProperties
public class GeneralConfig {
}
