package com.dawidkotarba.playground.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */
@Configuration
@ComponentScan("com.dawidkotarba.playground")
@EnableAsync
@EnableScheduling
public class GeneralConfig {
}
