package com.readspring.interfacebean.factorybean.v2;

import com.readspring.entity.User;
import com.readspring.interfacebean.factorybean.v1.MapperProxyRegister;
import com.readspring.interfacebean.mapper.OrderMapper;
import com.readspring.interfacebean.mapper.UserMapper;
import com.readspring.interfacebean.mapper.proxy.MapperProxyFactory;
import com.readspring.interfacebean.mapper.proxy.MapperScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 在使用 dubbo 或者 openFeign 做服务调用时，通常通过注入 dubbo 或者 openFeign 的服务接口进行调用远程服务，并没有手写接口服务的实现。
 * 同样的在使用 mybatis 是我们没有写 mapper 接口的实现，框架是如何做的？
 *
 * 方法一：自己扫描，自己生成 FactoryBean 的 BeanDefinition，在getObject代理
 * 在 spring 中，提供 FactoryBean 的接口，在容器启动时不仅将 FactoryBean 的实现注入到容器中，
 * 同时也会将 FactoryBean#getObject 的对象也注入到容器中，因此只需要在 getObject 方法中实现接口的代理。
 * 因此，扫描需要代理的接口，根据接口信息生成对应的FactoryBean的bean定义，并注入到容器中，其中在FactoryBean#getObject 完成接口的代理。
 *
 * PS: 该方式一般需要我们自定义注解，在spring 生命周期中自己去扫描我们定义的接口。
 *
 * 方式二：spring 扫描，spring 生成 bean定义，自己修改接口的 BeanDefinition 成 FactoryBean 的 BeanDefinition。
 * 使用 spring 的注解，如@Component，让 spring 帮我们扫描接口。但是接口是不能实例化的，
 * 因此在该接口bean实例化前去修改该bean 的 BeanDefinition，通常都是修改成 FactoryBean 的 BeanDefinition。
 *
 * PS：该方式一般自定义注解包装 spring 注解的注解，然后干涉接口 bean 的 BeanDefinition。
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.readspring.interfacebean.factorybean.v2"})
@Import({MapperBeanDefinitionRegistryPostProcessor.class, OrderMapper.class})
public class MyInterfaceBeanMainV2 {

	public static void main(String[] args) {
//		new MyInterfaceBeanMain().testGeneric1();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyInterfaceBeanMainV2.class);
		OrderMapper bean = context.getBean(OrderMapper.class);
		System.out.println(bean.get(new User()));
	}


	private void testGeneric1() {
		MapperProxyFactory<UserMapper> proxyFactory = new MapperProxyFactory<>();
		// 传入泛型类则使用 ？
		UserMapper userMapper = proxyFactory.newProxyInstance(new Class<?>[]{UserMapper.class});
		userMapper.get(new User());
	}
}
