package com.readspring.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author yanggy
 */
public class TestBeanDefinition {

	@Test
	public void testBeanDefinition() {
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName("com.readspring.entity.User");
		beanDefinition.setScope("singleton");
		beanDefinition.setInitMethodName("init");

		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue("username", "kato");
		propertyValues.addPropertyValue("sex", "女");
		beanDefinition.setPropertyValues(propertyValues);
		System.out.println(beanDefinition);
	}
}
