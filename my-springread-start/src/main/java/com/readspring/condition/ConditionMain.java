package com.readspring.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConditionConfig.class);
		System.out.println(context.containsBean("myBean"));
	}
}