package com.readspring.interfacebean.mapper.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MapperProxy implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Class<?> returnType = method.getReturnType();
		System.out.println(method.getName() +  "  方法参数参数= " + Arrays.toString(args));
		System.out.println("执行...");
		System.out.println(method.getName() +  " 执行结束 ");
		return returnType.newInstance();
	}
}
