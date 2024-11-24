package com.readspring.tools.spi;

public class OneHelloSpiImpl implements HelloSpi {
	@Override
	public String getName() {
		return "One";
	}

	@Override
	public void handle() {
		System.out.println(getName() + "执行");
	}
}