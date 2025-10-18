package com.readspring.theadbean.factory;

import com.readspring.theadbean.serivce.MyTheadBeanService;
import com.readspring.theadbean.serivce.MyTheadBeanServiceImpl;
import com.readspring.theadbean.serivce.TheadBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

public
class TheadBeanFactory implements ObjectFactory<TheadBean> {

	private final BeanFactory beanFactory;

	public TheadBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	@Override
	public TheadBean getObject() throws BeansException {
		return new MyTheadBeanServiceImpl();
	}

}