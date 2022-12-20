package com.readspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 *
 */
@Configuration
@ComponentScan(basePackages = "com.readspring", excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class}),
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {WebAppConfig.class})
})
public class AppConfig {
}
