package com.readspring;

import com.readspring.config.AppConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

//public class MyWebApplicationInitializer implements WebApplicationInitializer {
public class MyWebApplicationInitializer {

//	@Override
	public void onStartup(ServletContext servletContext) {

		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);

		AnnotationConfigWebApplicationContext context1 = new AnnotationConfigWebApplicationContext();
		context1.register(AppConfig.class);

		AnnotationConfigWebApplicationContext parent = new AnnotationConfigWebApplicationContext();
		parent.register(AppConfig.class);

		context.setParent(parent);
		context1.setParent(parent);


		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");

		DispatcherServlet servlet1 = new DispatcherServlet(context1);
		ServletRegistration.Dynamic registration1 = servletContext.addServlet("app1", servlet);
		registration1.setLoadOnStartup(1);
		registration1.addMapping("/");
	}
}
