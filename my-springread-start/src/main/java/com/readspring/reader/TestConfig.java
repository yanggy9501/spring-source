package com.readspring.reader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

	@Bean
	public TestConfig testConfig() {
		return new TestConfig();
	}
}
