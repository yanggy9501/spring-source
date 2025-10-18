package com.readspring.theadbean;

import com.readspring.theadbean.serivce.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TheadBeanTestMain {
	public static void main(String[] args) {
		System.out.println("hello spring");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TheadBenConfig.class);
		DemoService service = context.getBean(DemoService.class);
		service.test();
	}
}
