package com.readspring.lifecycle.bean;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * BeanDefinition 后置处理器父类还是 BeanPostProcessor
 * 在构造方法创建实例之后调用，可修改 BeanDefinition 可影响后面的属性注入、aop 等
 *
 * @author yanggy
 */
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {

	}
}
