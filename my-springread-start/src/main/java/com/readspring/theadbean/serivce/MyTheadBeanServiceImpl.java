package com.readspring.theadbean.serivce;

public class MyTheadBeanServiceImpl implements MyTheadBeanService {
	private int a = 0;

	@Override
	public void func1() {
		for (int i = 0; i < 100; i++) {
			a += 1;
		}

		System.out.println(a);
	}
}
