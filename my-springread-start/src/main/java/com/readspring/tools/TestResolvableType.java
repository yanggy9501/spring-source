package com.readspring.tools;

import com.readspring.entity.User;
import org.springframework.core.ResolvableType;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

/**
 * 可解析的类
 *
 * @author yanggy
 */
public class TestResolvableType {
	public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
		new TestResolvableType().testResolvableType();
	}

	public void testResolvableType() throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
		User user = new User();
		ResolvableType resolvableType = ResolvableType.forField(user.getClass().getDeclaredField("name"));
		resolvableType.getSuperType();
		resolvableType.asMap();
		resolvableType.getGeneric(0).resolve();// 获取第一个泛型
		resolvableType.getGeneric(1).resolve();// 获取第2个泛型

	}

}
