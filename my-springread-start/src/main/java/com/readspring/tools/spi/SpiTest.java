package com.readspring.tools.spi;

import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.Iterator;
import java.util.List;

public class SpiTest {
	public static void main(String[] args) {
		SpiTest spiTest = new SpiTest();
		spiTest.testSpringSpi();
	}

	public void testSpringSpi() {
		List<HelloSpi> helloSpiList = SpringFactoriesLoader.loadFactories(HelloSpi.class, this.getClass().getClassLoader());
		Iterator<HelloSpi> iterator = helloSpiList.iterator();
		while (iterator.hasNext()) {
			HelloSpi next = iterator.next();
			System.out.println(next.getName() + " 准备执行");
			next.handle();
		}
		System.out.println("执行结束");
	}

}
