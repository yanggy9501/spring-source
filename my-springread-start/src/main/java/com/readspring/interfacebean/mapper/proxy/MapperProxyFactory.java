package com.readspring.interfacebean.mapper.proxy;


import java.lang.reflect.Proxy;

public class MapperProxyFactory<T> {
	@SuppressWarnings("unchecked")
	public T newProxyInstance(Class<?>[] interfaces) {
		Object proxyInstance = Proxy.newProxyInstance(
				MapperProxyFactory.class.getClassLoader(),
				interfaces,
				new MapperProxy()
		);
		return (T) proxyInstance;
	}
}
