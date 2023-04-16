package com.readspring.tools;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.StandardEnvironment;

import java.util.Properties;

/**
 * @author yanggy
 */
public class TestEnvironment {
	public static void main(String[] args) {
		new TestEnvironment().tetAddCustomerEnvironment();
	}

	public void testEnvironmentPropeties() {
		GenericApplicationContext applicationContext = new GenericApplicationContext();
		ConfigurableEnvironment environment = applicationContext.getEnvironment();

		String javaHome = environment.getProperty("JAVA_HOME");
		System.out.println(javaHome);
	}

	public void tetStandardEnvironment() {
		StandardEnvironment environment = new StandardEnvironment();
		System.out.println(environment);
	}

	/**
	 * 添加自定义的属性
	 */
	public void tetAddCustomerEnvironment() {
		StandardEnvironment environment = new StandardEnvironment();
		Properties properties = new Properties();
		properties.put("iname", "kato");
		PropertiesPropertySource propertySource = new PropertiesPropertySource("myproperties", properties);
		environment.getPropertySources().addLast(propertySource);

		System.out.println(environment);
		System.out.println(propertySource.getProperty("iname"));
	}
}
