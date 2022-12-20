package com.readspring.lifecycle.aware;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.stereotype.Component;

/**
 * bean类加载器感知
 * 属性填充之后调用（每个bean都会调用，如果能走到这步的话）
 *
 * @author yanggy
 */
@Component
public class MyBeanClassLoaderAware implements BeanClassLoaderAware {
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {

	}
}
