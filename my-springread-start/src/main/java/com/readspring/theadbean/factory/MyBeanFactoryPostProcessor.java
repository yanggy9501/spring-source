package com.readspring.theadbean.factory;

import com.readspring.theadbean.serivce.TheadBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;


@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		beanFactory.registerResolvableDependency(TheadBean.class, new TheadBeanFactory(beanFactory));
    }
}
