package com.readspring.interfacebean.factorybean.v2;

import com.readspring.interfacebean.factorybean.v1.MapperFactoryBeanV1;
import com.readspring.interfacebean.mapper.proxy.MapperProxyFactory;
import com.readspring.interfacebean.mapper.proxy.MapperSpring;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

@Component
public class MapperBeanDefinitionRegistryPostProcessor implements ApplicationContextAware, BeanClassLoaderAware, BeanFactoryPostProcessor {

	private ApplicationContext context;
	private ClassLoader classLoader;

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
		for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
			String beanClassName = beanDefinition.getBeanClassName();
			if (beanClassName != null) {
				Class<?> clazz = ClassUtils.resolveClassName(beanClassName, this.classLoader);
				if (clazz.isAnnotationPresent(MapperSpring.class)) {

					registry.removeBeanDefinition(beanDefinitionName);

					// 使用 FactoryBean#getObject 完成代理
					BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(MapperFactoryBeanV1.class);
					definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

					String interfaceType = ((AnnotatedBeanDefinition) beanDefinition).getMetadata().getClassName();
					definition.addPropertyValue("type", interfaceType);
					definition.addPropertyValue("mapperProxyFactory", new MapperProxyFactory<>());

					// 单例
					definition.setScope("singleton");
					AbstractBeanDefinition abstractBeanDefinition = definition.getBeanDefinition();

					String beanName = interfaceType;
					BeanDefinitionHolder holder = new BeanDefinitionHolder(abstractBeanDefinition, beanName, new String[]{beanName});

					BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
				}
			}
		}
	}

}
