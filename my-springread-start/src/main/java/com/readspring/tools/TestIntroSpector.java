package com.readspring.tools;

import com.readspring.entity.User;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 内省 api
 *
 * @author yanggy
 */
public class TestIntroSpector {
	public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
		new TestIntroSpector().testIntroSpector();
	}

	/**
	 * 内省 api
	 *
	 * @throws IntrospectionException
	 */
	public void testIntroSpector() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
		// 不要继承父类Object的属性
		BeanInfo beanInfo1 = Introspector.getBeanInfo(User.class, Object.class);
		// 获取属性描述器
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			System.out.println(propertyDescriptor.getName());
			System.out.println(propertyDescriptor.getPropertyType());
			System.out.println(propertyDescriptor.getReadMethod());
			System.out.println(propertyDescriptor.getWriteMethod());
		}
		// --------------------- 直接 new 属性描述器
		// new PropertyDescriptor("类的属性名", User.class);
		PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", User.class);
		System.out.println(propertyDescriptor.getName());

		// 获取方法的描述器
		MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
		Method writeMethod = propertyDescriptor.getWriteMethod();
		User user = new User();
		writeMethod.invoke(user, "kato");
		System.out.println(user);

	}

	public void testBeanUtils() {
		User user = new User();
	}
}
