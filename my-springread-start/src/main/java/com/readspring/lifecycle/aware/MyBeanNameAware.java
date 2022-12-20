package com.readspring.lifecycle.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * bean名称感知器
 * 属性填充之后调用（每个bean都会调用，如果能走到这步的话）
 *
 * @author yanggy
 */
@Component
public class MyBeanNameAware implements BeanNameAware {
	@Override
	public void setBeanName(String name) {

	}
}
