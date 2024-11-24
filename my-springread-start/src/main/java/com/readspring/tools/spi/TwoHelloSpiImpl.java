package com.readspring.tools.spi;

public class TwoHelloSpiImpl implements HelloSpi {
	@Override
	public String getName() {
		return "Two";
	}

	@Override
	public void handle() {
		System.out.println(getName() + "执行");
	}
}