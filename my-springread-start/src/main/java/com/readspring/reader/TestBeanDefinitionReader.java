package com.readspring.reader;

import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * @author yanggy
 */
public class TestBeanDefinitionReader {
	public static void main(String[] args) {
		new TestBeanDefinitionReader().testRegistryByAnnotation();
	}
	public void testXmlBeanDefinitionReader() {
		// 创建一个基于 Map 的简单工厂
		SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		int i = reader.loadBeanDefinitions("classpath:bean.xml");
		System.out.println(i);
		System.out.println(registry.getBeanDefinition("user"));
	}

	public void testAnnotatedBeanDefinitionReader() {
		// 创建一个基于 Map 的简单工厂
		SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(registry);
		// 该 reader 只能解析 registerBean 方法张传递的类，其内部定义的 Bean 是无法解析的
		reader.registerBean(TestConfig.class);
		System.out.println(registry.getBeanDefinition("user"));
	}

	/**
	 * ClassPathBeanDefinitionScanner
	 */
	public void testRegistryByAnnotation() {
		SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
		scanner.scan("com.readspring.reader");
		System.out.println(registry.getBeanDefinitionCount());
	}
}
