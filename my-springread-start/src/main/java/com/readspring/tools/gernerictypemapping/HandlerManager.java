package com.readspring.tools.gernerictypemapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

@Component
public class HandlerManager {

	@Autowired
	private List<Handler<?>> handlerList;

	@Autowired
	private List<MethodHandler> methodHandlerList;

	public <T> void handler(T input) {
		if (input == null) {
			return;
		}
		ResolvableType inputResolvableType = ResolvableType.forInstance(input);

		for (Handler<?> handler : handlerList) {
			ResolvableType handlerResolvableType = ResolvableType.forClass(handler.getClass()).as(Handler.class);
			ResolvableType genericHandlerResolvableType = handlerResolvableType.getGeneric(0);
			if (genericHandlerResolvableType.isAssignableFrom(inputResolvableType)) {
				@SuppressWarnings("unchecked")
				Handler<T> tHandler = (Handler<T>) handler;
				tHandler.handle(input);
			}
		}
	}


	public <T> void handler2(T input) {
		if (input == null) {
			return;
		}
		ResolvableType inputResolvableType = ResolvableType.forInstance(input);
		for (MethodHandler methodHandler : methodHandlerList) {
			Method[] methods = methodHandler.getClass().getMethods();
			for (Method method : methods) {
				if (method.isDefault()
						|| !Modifier.isPublic(method.getModifiers())
						|| Modifier.isStatic(method.getModifiers())) {
					continue;
				}
				// 只接受单参数方法
				if (method.getParameterCount() != 1) {
					continue;
				}
				ResolvableType methodParameterResolvableType = ResolvableType.forMethodParameter(method, 0);
				if (methodParameterResolvableType.isAssignableFrom(inputResolvableType)) {
					// 执行方法
					try {
						method.invoke(methodHandler, input);
					} catch (IllegalAccessException e) {
						// 理论上不会发生，因为前面已经过滤了非 public 方法
						throw new RuntimeException("方法不可访问: " + method.getName(), e);
					} catch (InvocationTargetException e) {
						// 方法内部抛出的异常会被包装成 InvocationTargetException
						throw new RuntimeException("方法执行失败: " + method.getName(), e.getCause());
					}
					// 如果只需要匹配第一个就返回，去掉下面这行会继续遍历所有匹配的方法
					return;
				}
			}
		}
	}
}