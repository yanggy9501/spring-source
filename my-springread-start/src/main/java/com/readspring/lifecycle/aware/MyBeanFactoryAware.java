package com.readspring.lifecycle.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * bean容器感知
 * 属性填充之后调用（每个bean都会调用，如果能走到这步的话）
 *
 * @author yanggy
 */
@Component
public class MyBeanFactoryAware implements BeanFactoryAware {
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

	}
}
