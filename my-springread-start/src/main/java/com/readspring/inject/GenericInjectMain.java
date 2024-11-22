package com.readspring.inject;

import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 在这种情况下，Spring 应该能够正确识别并注入合适的泛型类型 Bean。
 * 要实现泛型依赖注入，Spring 会在启动时扫描所有的 Bean 定义，并根据泛型类型进行匹配和注入。具体步骤如下：
 * 【不是利用反射】
 * （1）类型解析
 * Spring 使用一种称为 ResolvableType 的类型解析器来解析 Bean 定义中的泛型信息。
 * ResolvableType resolvableType = ResolvableType.forClass(ServiceA.class);
 *
 * （2）Bean 定义注册
 * 在 Spring 容器启动时，它会根据类的声明来注册 Bean 定义。如果一个类使用了泛型，Spring 会记录该 Bean 定义的泛型类型信息。
 *
 * （3）自动装配（Autowiring）
 * 在 Spring 的自动装配过程中，Spring 会根据 Field 或 Setter 方法的泛型类型信息来查找匹配的 Bean。
 *
 */
/*
1. 什么是 ResolvableType？
ResolvableType 是 Spring 4.0 引入的一个用于处理 Java 类型的工具类。它可以解析字段、方法参数和方法返回类型中包含的泛型信息。
ResolvableType 提供了一种动态解析和操作 Java 类型信息的方式，特别是泛型信息。

2. ResolvableType 的常见用法
ResolvableType 可以通过多种方式创建，主要包括：
使用 ResolvableType.forClass 来解析一个类的类型。
使用 ResolvableType.forField 来解析字段的类型。
使用 ResolvableType.forMethodParameter 来解析方法参数的类型。
使用 ResolvableType.forMethodReturnType 来解析方法返回值的类型。

3. 如何解析 Bean 定义中的泛型信息？
以下是 Spring 利用ResolvableType 来解析 Bean 定义中泛型信息的具体步骤和代码示例：

注意：spring 应该是通过静态代码进行泛型分析的，如果是运行期间的泛型则无法获取

 */
public class GenericInjectMain {
	public static void main(String[] args) {
		ResolvableType resolvableType = ResolvableType.forClass(ServiceA.class);
		//
		ResolvableType resolvableType1 = ResolvableType.forClass(new ServiceA<BigDecimal>().getClass());
		// 有具体泛型
		ResolvableType resolvableType2 = ResolvableType.forClassWithGenerics(ServiceA.class, ResolvableType.forInstance(""));

		ResolvableType resolvableType4 = ResolvableType.forClass(StringService.class);

		ResolvableType resolvableType5 = ResolvableType.forClass(new StringService().getClass());

		System.out.println(resolvableType);
		System.out.println(resolvableType1);
		System.out.println(resolvableType2);

		// 获取泛型参数类型
		ResolvableType genericType = resolvableType1.getGeneric(0);
		System.out.println("GenericType: " + genericType.getType().getTypeName()); // 无法获取具体泛型 BigDecimal


		ResolvableType superType4 = resolvableType4.getSuperType();
		ResolvableType genericType4 = superType4.getGeneric(0);
		System.out.println("GenericType: " + genericType4.getType().getTypeName()); // 能获取到具体的泛型 string

		ResolvableType superType5 = resolvableType5.getSuperType();
		ResolvableType genericType5 = superType5.getGeneric(0);
		System.out.println("GenericType: " + genericType5.getType().getTypeName()); // 能获取到具体的泛型 string
	}

	@Component
	public static class ServiceA<T> {
		// Some code here
	}

	@Component
	public static class StringService extends ServiceA<String> {
		// Implementation for String type
	}

	@Component
	public static class IntegerService extends ServiceA<Integer> {
		// Implementation for Integer type
	}
}
