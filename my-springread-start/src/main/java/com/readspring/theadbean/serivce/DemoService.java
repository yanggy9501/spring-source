package com.readspring.theadbean.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	// 可以注入 MyTheadBeanService，但是容器里面是没有 MyTheadBeanService 的，即 getBean 是不存在的
	@Autowired
	private MyTheadBeanService myService;

	public void test() {
		myService.func1();
	}
}
