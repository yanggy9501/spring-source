package com.readspring.tools;

import com.readspring.entity.Order;
import com.readspring.entity.User;
import org.springframework.core.ResolvableType;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

/**
 * 可解析的类，解析bean的类型，包含类，方法，参数，返回值的泛型信息
 *
 * @author yanggy
 */
public class TestResolvableType {
	public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
//		new TestResolvableType().testResolvableType();
//		new TestResolvableType().testResolvableTypeServiceABC();
		new TestResolvableType().getGenericForJdk();
	}

	public void testResolvableType() throws  NoSuchFieldException {
		User user = new User();
		ResolvableType resolvableType = ResolvableType.forField(user.getClass().getDeclaredField("name"));
		resolvableType.getSuperType();
		resolvableType.asMap();
		resolvableType.getGeneric(0).resolve();// 获取第一个泛型
		resolvableType.getGeneric(1).resolve();// 获取第2个泛型

	}

	public void testResolvableTypeServiceABC() throws NoSuchFieldException {
		ServiceABC serviceABC = new ServiceABC();
		ResolvableType uServiceResolvableType = ResolvableType.forField(serviceABC.getClass().getDeclaredField("uService"));
		System.out.println(uServiceResolvableType.getGeneric(0).resolve());

		ResolvableType oServiceResolvableType = ResolvableType.forField(serviceABC.getClass().getDeclaredField("oService"));
		System.out.println(oServiceResolvableType.getGeneric(0).resolve());

	}

	public void getGenericForJdk() throws NoSuchFieldException {
		Field param = ServiceABC.class.getDeclaredField("uService");
		Type genericType = param.getGenericType();
		ParameterizedType type = (ParameterizedType) genericType;
		Type[] typeArguments = type.getActualTypeArguments();
		System.out.println("从 ServiceABC 中获取 uService<?> 泛型:" + typeArguments[0]);
	}

	public static class ServiceA<T> {
		// Some code here
	}

	public static class StringService extends ResolvableTypeMain.ServiceA<String> {
		// Implementation for String type
	}

	public static class IntegerService extends ResolvableTypeMain.ServiceA<Integer> {
		// Implementation for Integer type
	}

	public static class ServiceABC {
		private ServiceA<User> uService;

		private ServiceA<Order> oService;
	}
}
