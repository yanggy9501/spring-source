package com.readspring.condition;

import com.readspring.condition.bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:spring.properties"})
public class MyConditionConfig {

	// my.condition.enabled 可以通过配置文件或者配置中心进行配置，然后当my.condition.enabled属性为true时，MyBean才会被创建。
	@Bean
	@Conditional(MyCondition.class)
	public MyBean myBean() {
		return new MyBean();
	}
}