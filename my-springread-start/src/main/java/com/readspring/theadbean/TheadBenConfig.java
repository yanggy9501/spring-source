package com.readspring.theadbean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = {"com.readspring.theadbean"})
public class TheadBenConfig {

}
