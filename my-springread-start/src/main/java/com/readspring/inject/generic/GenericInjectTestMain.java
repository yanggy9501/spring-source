package com.readspring.inject.generic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.readspring.inject.generic"})
public class GenericInjectTestMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GenericInjectTestMain.class);

		HandlerService bean = context.getBean(HandlerService.class);
		bean.test();
		System.out.println(bean);
	}
}
