package com.readspring;

import com.readspring.config.AppConfig;
import com.readspring.proxy.IRequireProxyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		System.out.println("hello spring");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		LookupService lookupService = context.getBean("lookupService", LookupService.class);
//		System.out.println(lookupService);
//		lookupService.test();
		IRequireProxyService requireProxyService = context.getBean("requireProxyService", IRequireProxyService.class);
		requireProxyService.func1();
		System.out.println(requireProxyService);
	}
}