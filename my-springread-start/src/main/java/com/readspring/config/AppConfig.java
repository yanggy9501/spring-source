package com.readspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = {"com.readspring"})
@PropertySource("classpath:spring.properties")
@EnableAspectJAutoProxy(exposeProxy = true)
public class AppConfig {

}
