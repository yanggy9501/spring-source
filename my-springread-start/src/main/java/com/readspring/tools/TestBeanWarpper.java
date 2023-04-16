package com.readspring.tools;

import com.readspring.entity.User;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author yanggy
 */
public class TestBeanWarpper {
	public static void main(String[] args) {
		new TestBeanWarpper().testBeanWarpper();
	}

	public void testBeanWarpper() {
		User user = new User();
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName("com.readspring.entity.User");
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue("name", "kato");
		propertyValues.addPropertyValue("age", "19");
		beanDefinition.setPropertyValues(propertyValues);

		BeanWrapper beanWrapper = new BeanWrapperImpl(user.getClass());
		beanWrapper.setPropertyValues(beanDefinition.getPropertyValues());
		Object instance = beanWrapper.getWrappedInstance();
		System.out.println(instance);
	}
}
