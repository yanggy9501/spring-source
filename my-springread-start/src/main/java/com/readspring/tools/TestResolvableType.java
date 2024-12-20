package com.readspring.tools;

import com.readspring.entity.Order;
import com.readspring.entity.User;
import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 可解析的类，解析bean的类型，包含类，方法，参数，返回值的泛型信息。
 *
 * 泛型类可以使用 ResolvableType 类统一表示，泛型类型信息都可以通过 ResolvableType 中的方法直接获取，而不必再额外调用其他类的方法，
 * 获取父类型信息的时候，ResolvableType 还友好的获取到了父类型中的实际类型，ResolvableType 提供的能力远不止如此。
 *
 * @author yanggy
 */
public class TestResolvableType { // / rɪˈzɑːlvəbl /
	public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
//		new TestResolvableType().testResolvableType();
//		new TestResolvableType().testResolvableTypeServiceABC();
		new TestResolvableType().getGenericForJdk();
	}

	/**
	 * 获取泛型类
	 */
	public void testResolvableType() throws  NoSuchFieldException {
		User user = new User();
		ResolvableType resolvableType = ResolvableType.forField(user.getClass().getDeclaredField("name"));
		resolvableType.getSuperType();
		resolvableType.asMap();
		resolvableType.getGeneric(0).resolve();// 获取第一个泛型
		resolvableType.getGeneric(1).resolve();// 获取第2个泛型

	}

	/**
	 * 获取泛型字段
	 */
	public void testResolvableTypeServiceABC() throws NoSuchFieldException {
		ServiceABC serviceABC = new ServiceABC();
		ResolvableType uServiceResolvableType = ResolvableType.forField(serviceABC.getClass().getDeclaredField("uService"));
		System.out.println(uServiceResolvableType.getGeneric(0).resolve());

		ResolvableType oServiceResolvableType = ResolvableType.forField(serviceABC.getClass().getDeclaredField("oService"));
		System.out.println(oServiceResolvableType.getGeneric(0).resolve());

	}

	/**
	 * 获取泛型字段
	 */
	public void testResolvableTypeField() throws NoSuchFieldException {
		ResolvableType resolvableType4 = ResolvableType.forField(ReflectionUtils.findField(GenericFiled.class, "map"));
		resolvableType4.getGeneric(1).getGeneric(1).resolve();
	}

	/**
	 * 获取泛型返回值
	 */
	public void testResolvableTypeReturn() throws NoSuchFieldException {
		ResolvableType resolvableType5 = ResolvableType.forMethodReturnType(ReflectionUtils.findMethod(GenericFiled.class, "methodName"));
		System.out.println(resolvableType5.getGeneric(1, 0).resolve());

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

	public static class  GenericFiled {

		private Map<String, Map<String, Integer>> map;

		// ....
		public Map<String, Map<String, Integer>> methodName() {
			return null;
		}
	}

}
