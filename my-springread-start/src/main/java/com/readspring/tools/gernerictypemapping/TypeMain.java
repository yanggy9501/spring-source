package com.readspring.tools.gernerictypemapping;

import com.readspring.tools.gernerictypemapping.obj.Msg;
import com.readspring.tools.gernerictypemapping.obj.Tag;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.readspring.tools.gernerictypemapping"})
public class TypeMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TypeMain.class);
		System.out.println("--------------------------------------------------------");

		HandlerManager handlerManager = context.getBean(HandlerManager.class);

		handlerManager.handler(new Tag("Tag type object"));
		handlerManager.handler(new Msg("Msg type object", 100));

		System.out.println("--------------------------------------------------------");

		handlerManager.handler2(new Tag("Tag2 type object"));
		handlerManager.handler2(new Msg("Msg2 type object", 200));
	}
}
